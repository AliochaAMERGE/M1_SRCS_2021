package srcs.map.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import srcs.grpc.util.BuilderUtil;
import srcs.map.EntryString;
import srcs.map.MapStringRemoteGrpc;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteBlockingStub;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteFutureStub;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteStub;
import srcs.map.impl.MapStringRemoteImpl;

public class TestRemoteMapString {

	static int port=5454;
	
	static ManagedChannel chan;
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		
		//deploiement de la partie serveur
		ServerBuilder<?> serverbuilder = ServerBuilder.forPort(port)
													.addService(new MapStringRemoteImpl());
		
		Server server = BuilderUtil.disableStat(serverbuilder).build();
		
		server.start();
		
		//déploiement de la partie cliente
		
		chan = BuilderUtil.disableStat(ManagedChannelBuilder.forAddress("localhost", port)
				.usePlaintext())
				.build();
		
	}
	
	
	
	@Test
	public void testBlocking() throws Exception {
		String key = "toto";
		String val = "valtoto";
		MapStringRemoteBlockingStub map  =MapStringRemoteGrpc.newBlockingStub(chan);
		
		Empty ret = map.put(EntryString.newBuilder().setKey(key).setValue(val).build());
		
		String res = map.get(StringValue.of(key)).getValue();
		
		assertEquals(val,res);		
	}
	
	
	@Test
	public void testUnBlockingFuture() throws Exception{
		String key = "toto";
		String val = "valtoto";
		MapStringRemoteFutureStub map = MapStringRemoteGrpc.newFutureStub(chan);
		ListenableFuture<Empty> futureret = map.put(EntryString.newBuilder().setKey(key).setValue(val).build());
		//on peut faire autre chose en attendant la fin
		Empty ret  = futureret.get();
		
		ListenableFuture<StringValue> futureret2 = map.get(StringValue.of(key));
		
		String res = futureret2.get().getValue();
		
		assertEquals(val,res);		
	}

	
	final Object verrou=new Object();
	boolean recu= false;
	String tmp;
	
	@Test
	public void testUnBlocking() throws Exception{
		String key = "toto";
		String val = "valtoto";
		MapStringRemoteStub map = MapStringRemoteGrpc.newStub(chan);
		recu= false;
		map.put(EntryString.newBuilder().setKey(key).setValue(val).build(), new StreamObserver<Empty>() {
			
			@Override
			public void onNext(Empty arg0) {}
			
			@Override
			public void onError(Throwable arg0) {}
			
			@Override
			public void onCompleted() {
				synchronized (verrou) {
					recu= true;	
					verrou.notify();
				}				
			}
		});
		//on peut faire autre chose en attendant la fin
		synchronized(verrou) {
			while(!recu)
				verrou.wait();
		}
		
		recu= false;
		
		map.get(StringValue.of(key), new StreamObserver<StringValue>() {

			@Override
			public void onCompleted() {
				synchronized (verrou) {
					recu= true;	
					verrou.notify();
				}				
			}

			@Override
			public void onError(Throwable arg0) {}

			@Override
			public void onNext(StringValue arg0) {
				tmp=arg0.getValue();		
			}
		});
		//on peut faire autre chose en attendant la fin
		synchronized(verrou) {
			while(!recu)
				verrou.wait();
		}
		String res=tmp;
		assertEquals(val,res);		
		
	}
	
	
}
