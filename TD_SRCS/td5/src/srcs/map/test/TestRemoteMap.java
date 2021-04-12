package srcs.map.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import srcs.grpc.util.BuilderUtil;
import srcs.map.Entry;
import srcs.map.MapRemoteGrpc;
import srcs.map.MapRemoteGrpc.MapRemoteBlockingStub;
import srcs.map.impl.MapRemoteImpl;

public class TestRemoteMap {

	static int port=5454;
	
	static ManagedChannel chan;
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		
		//deploiement de la partie serveur
		ServerBuilder<?> serverbuilder = ServerBuilder.forPort(port)
													.addService(new MapRemoteImpl());
		
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
		MapRemoteBlockingStub map  =MapRemoteGrpc.newBlockingStub(chan);
		
		Entry message_aller = Entry.newBuilder()
								 .setKey(Any.pack(StringValue.of(key)))
								 .setValue(Any.pack(StringValue.of(val))).build();
		
		Empty ret = map.put(message_aller);
	
		
		Any anyres = map.get(Any.pack(StringValue.of(key)));
		
		String res = anyres.unpack(StringValue.class).getValue();
		assertEquals(val,res);		
	}
	
	
}
