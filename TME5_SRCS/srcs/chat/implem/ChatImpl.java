package srcs.chat.implem;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import srcs.chat.ChatGrpc;
import srcs.chat.SendChat;
import srcs.chat.SubscribeChat;
import srcs.chat.ChatGrpc.ChatImplBase;
import srcs.chat.ChatGrpc.ChatStub;

public class ChatImpl extends ChatImplBase {
	Map<String, SubscribeChat> mapUsers = new HashMap<>();

	@Override
	public void subscribe(SubscribeChat request,
			StreamObserver<BoolValue> responseObserver) {
		String pseudo = request.getPseudo();

		if (!mapUsers.containsKey(pseudo)) {
			mapUsers.put(pseudo, request);
			responseObserver.onNext(BoolValue.of(true));
		}
		responseObserver.onNext(BoolValue.of(false));
		responseObserver.onCompleted();
	}

	@Override
	public void send(SendChat request,
			StreamObserver<Int32Value> responseObserver) {
		String pseudo = request.getPseudo();
		String message = request.getMessage();

		String host = null;
		int port = 0;

		for (String user : mapUsers.keySet()) {
			if (!pseudo.equals(user)) {
				ManagedChannel chan = ManagedChannelBuilder
						.forAddress(host, port).usePlaintext().build();
				SendChat sc = SendChat.newBuilder().setPseudo(pseudo)
						.setMessage(message).build();

				ChatStub service = ChatGrpc.newStub(chan);

				service.send(sc, new StreamObserver<Int32Value>() {
					@Override
					public void onCompleted() {
					}

					@Override
					public void onError(Throwable arg0) {
					}

					@Override
					public void onNext(Int32Value arg0) {
					}

				});
			}
		}

		responseObserver.onNext(Int32Value.of(mapUsers.size() - 1));
		responseObserver.onCompleted();

	}

	@Override
	public void listChatter(Empty request,
			StreamObserver<StringValue> responseObserver) {

		for (String user : mapUsers.keySet())
			responseObserver.onNext(StringValue.of(user));

		responseObserver.onCompleted();

	}

	@Override
	public void unsubscribe(StringValue request,
			StreamObserver<Empty> responseObserver) {
		String pseudo = request.getValue(); // pseudo
		if (mapUsers.containsKey(pseudo))
			mapUsers.remove(pseudo); // se désabonner

		responseObserver.onNext(Empty.getDefaultInstance());
		responseObserver.onCompleted();

	}

}
