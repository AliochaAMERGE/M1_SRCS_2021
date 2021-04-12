package srcs.map.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import srcs.map.Entry;
import srcs.map.MapRemoteGrpc.MapRemoteImplBase;

public class MapRemoteImpl extends MapRemoteImplBase {

	private Map<Any,Any> map = new HashMap<>();
	
	@Override
	public void get(Any request, StreamObserver<Any> lien_vers_client) {
		Any key = request;
		Any res;
		synchronized(map) {
			if(map.containsKey(key)) {
				res=map.get(key);
				lien_vers_client.onNext(res);
			}
			else {
				lien_vers_client.onError(new IllegalArgumentException("cle inexistante"));
				
			}
		}		
		lien_vers_client.onCompleted();
	}

	@Override
	public void put(Entry request, StreamObserver<Empty> lien_vers_client) {

		Any key = request.getKey();
		Any value = request.getValue();
		
		synchronized(map) {
			map.put(key, value);
		}
		
		lien_vers_client.onNext(Empty.getDefaultInstance());
		lien_vers_client.onCompleted();
	}
	
	
}
