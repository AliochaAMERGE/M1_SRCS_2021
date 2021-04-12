package srcs.map.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.stub.StreamObserver;
import srcs.map.EntryString;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteImplBase;

public class MapStringRemoteImpl extends MapStringRemoteImplBase{

	private final Map<String, String> map = new HashMap<>();

	@Override
	public  void get(StringValue request, StreamObserver<StringValue> lien_vers_client) {
		String key = request.getValue();
		String res="";
		
		synchronized(map) {
			if(map.containsKey(key)) {
				res=map.get(key);
			}
		}		
		lien_vers_client.onNext(StringValue.of(res));
		lien_vers_client.onCompleted();
	}

	@Override
	public synchronized void put(EntryString request, StreamObserver<Empty> lien_vers_client) {
		
		String key = request.getKey();
		String value = request.getValue();
		
		synchronized(map) {
			map.put(key, value);
		}
		
		lien_vers_client.onNext(Empty.getDefaultInstance());
		lien_vers_client.onCompleted();
		
	}
	
	
	
	
}
