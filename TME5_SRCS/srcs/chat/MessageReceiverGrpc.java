package srcs.chat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: chat.proto")
public final class MessageReceiverGrpc {

  private MessageReceiverGrpc() {}

  public static final String SERVICE_NAME = "srcs.chat.MessageReceiver";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<srcs.chat.NewMessageRec,
      com.google.protobuf.Empty> getNewMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newMessage",
      requestType = srcs.chat.NewMessageRec.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.NewMessageRec,
      com.google.protobuf.Empty> getNewMessageMethod() {
    io.grpc.MethodDescriptor<srcs.chat.NewMessageRec, com.google.protobuf.Empty> getNewMessageMethod;
    if ((getNewMessageMethod = MessageReceiverGrpc.getNewMessageMethod) == null) {
      synchronized (MessageReceiverGrpc.class) {
        if ((getNewMessageMethod = MessageReceiverGrpc.getNewMessageMethod) == null) {
          MessageReceiverGrpc.getNewMessageMethod = getNewMessageMethod =
              io.grpc.MethodDescriptor.<srcs.chat.NewMessageRec, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.NewMessageRec.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessageReceiverMethodDescriptorSupplier("newMessage"))
              .build();
        }
      }
    }
    return getNewMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageReceiverStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageReceiverStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageReceiverStub>() {
        @java.lang.Override
        public MessageReceiverStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageReceiverStub(channel, callOptions);
        }
      };
    return MessageReceiverStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageReceiverBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageReceiverBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageReceiverBlockingStub>() {
        @java.lang.Override
        public MessageReceiverBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageReceiverBlockingStub(channel, callOptions);
        }
      };
    return MessageReceiverBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageReceiverFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageReceiverFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageReceiverFutureStub>() {
        @java.lang.Override
        public MessageReceiverFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageReceiverFutureStub(channel, callOptions);
        }
      };
    return MessageReceiverFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MessageReceiverImplBase implements io.grpc.BindableService {

    /**
     */
    public void newMessage(srcs.chat.NewMessageRec request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.NewMessageRec,
                com.google.protobuf.Empty>(
                  this, METHODID_NEW_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageReceiverStub extends io.grpc.stub.AbstractAsyncStub<MessageReceiverStub> {
    private MessageReceiverStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageReceiverStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageReceiverStub(channel, callOptions);
    }

    /**
     */
    public void newMessage(srcs.chat.NewMessageRec request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageReceiverBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessageReceiverBlockingStub> {
    private MessageReceiverBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageReceiverBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageReceiverBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty newMessage(srcs.chat.NewMessageRec request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageReceiverFutureStub extends io.grpc.stub.AbstractFutureStub<MessageReceiverFutureStub> {
    private MessageReceiverFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageReceiverFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageReceiverFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> newMessage(
        srcs.chat.NewMessageRec request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageReceiverImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageReceiverImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_MESSAGE:
          serviceImpl.newMessage((srcs.chat.NewMessageRec) request,
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

  private static abstract class MessageReceiverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageReceiverBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.chat.ChatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessageReceiver");
    }
  }

  private static final class MessageReceiverFileDescriptorSupplier
      extends MessageReceiverBaseDescriptorSupplier {
    MessageReceiverFileDescriptorSupplier() {}
  }

  private static final class MessageReceiverMethodDescriptorSupplier
      extends MessageReceiverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageReceiverMethodDescriptorSupplier(String methodName) {
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
      synchronized (MessageReceiverGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageReceiverFileDescriptorSupplier())
              .addMethod(getNewMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
