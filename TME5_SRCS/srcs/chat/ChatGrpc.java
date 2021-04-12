package srcs.chat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: chat.proto")
public final class ChatGrpc {

  private ChatGrpc() {}

  public static final String SERVICE_NAME = "srcs.chat.Chat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<srcs.chat.SubscribeChat,
      com.google.protobuf.BoolValue> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = srcs.chat.SubscribeChat.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.SubscribeChat,
      com.google.protobuf.BoolValue> getSubscribeMethod() {
    io.grpc.MethodDescriptor<srcs.chat.SubscribeChat, com.google.protobuf.BoolValue> getSubscribeMethod;
    if ((getSubscribeMethod = ChatGrpc.getSubscribeMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getSubscribeMethod = ChatGrpc.getSubscribeMethod) == null) {
          ChatGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<srcs.chat.SubscribeChat, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SubscribeChat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.chat.SendChat,
      com.google.protobuf.Int32Value> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = srcs.chat.SendChat.class,
      responseType = com.google.protobuf.Int32Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.SendChat,
      com.google.protobuf.Int32Value> getSendMethod() {
    io.grpc.MethodDescriptor<srcs.chat.SendChat, com.google.protobuf.Int32Value> getSendMethod;
    if ((getSendMethod = ChatGrpc.getSendMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getSendMethod = ChatGrpc.getSendMethod) == null) {
          ChatGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<srcs.chat.SendChat, com.google.protobuf.Int32Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SendChat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMethodDescriptorSupplier("send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.StringValue> getListChatterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listChatter",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.StringValue> getListChatterMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.StringValue> getListChatterMethod;
    if ((getListChatterMethod = ChatGrpc.getListChatterMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getListChatterMethod = ChatGrpc.getListChatterMethod) == null) {
          ChatGrpc.getListChatterMethod = getListChatterMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listChatter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMethodDescriptorSupplier("listChatter"))
              .build();
        }
      }
    }
    return getListChatterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Empty> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unsubscribe",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Empty> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Empty> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = ChatGrpc.getUnsubscribeMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getUnsubscribeMethod = ChatGrpc.getUnsubscribeMethod) == null) {
          ChatGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMethodDescriptorSupplier("unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatStub>() {
        @java.lang.Override
        public ChatStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatStub(channel, callOptions);
        }
      };
    return ChatStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatBlockingStub>() {
        @java.lang.Override
        public ChatBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatBlockingStub(channel, callOptions);
        }
      };
    return ChatBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatFutureStub>() {
        @java.lang.Override
        public ChatFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatFutureStub(channel, callOptions);
        }
      };
    return ChatFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChatImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(srcs.chat.SubscribeChat request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void send(srcs.chat.SendChat request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    /**
     */
    public void listChatter(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListChatterMethod(), responseObserver);
    }

    /**
     */
    public void unsubscribe(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.SubscribeChat,
                com.google.protobuf.BoolValue>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getSendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.SendChat,
                com.google.protobuf.Int32Value>(
                  this, METHODID_SEND)))
          .addMethod(
            getListChatterMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.StringValue>(
                  this, METHODID_LIST_CHATTER)))
          .addMethod(
            getUnsubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.google.protobuf.Empty>(
                  this, METHODID_UNSUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatStub extends io.grpc.stub.AbstractAsyncStub<ChatStub> {
    private ChatStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(srcs.chat.SubscribeChat request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void send(srcs.chat.SendChat request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listChatter(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListChatterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatBlockingStub> {
    private ChatBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.BoolValue subscribe(srcs.chat.SubscribeChat request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int32Value send(srcs.chat.SendChat request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.StringValue> listChatter(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListChatterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unsubscribe(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatFutureStub extends io.grpc.stub.AbstractFutureStub<ChatFutureStub> {
    private ChatFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> subscribe(
        srcs.chat.SubscribeChat request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int32Value> send(
        srcs.chat.SendChat request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unsubscribe(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_SEND = 1;
  private static final int METHODID_LIST_CHATTER = 2;
  private static final int METHODID_UNSUBSCRIBE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((srcs.chat.SubscribeChat) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_SEND:
          serviceImpl.send((srcs.chat.SendChat) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value>) responseObserver);
          break;
        case METHODID_LIST_CHATTER:
          serviceImpl.listChatter((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.chat.ChatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chat");
    }
  }

  private static final class ChatFileDescriptorSupplier
      extends ChatBaseDescriptorSupplier {
    ChatFileDescriptorSupplier() {}
  }

  private static final class ChatMethodDescriptorSupplier
      extends ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getSendMethod())
              .addMethod(getListChatterMethod())
              .addMethod(getUnsubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
