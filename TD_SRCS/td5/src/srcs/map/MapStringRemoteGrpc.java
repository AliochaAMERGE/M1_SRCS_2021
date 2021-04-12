package srcs.map;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: mapStringRem.proto")
public final class MapStringRemoteGrpc {

  private MapStringRemoteGrpc() {}

  public static final String SERVICE_NAME = "srcs.map.MapStringRemote";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getGetMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.StringValue> getGetMethod;
    if ((getGetMethod = MapStringRemoteGrpc.getGetMethod) == null) {
      synchronized (MapStringRemoteGrpc.class) {
        if ((getGetMethod = MapStringRemoteGrpc.getGetMethod) == null) {
          MapStringRemoteGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new MapStringRemoteMethodDescriptorSupplier("get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.map.EntryString,
      com.google.protobuf.Empty> getPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put",
      requestType = srcs.map.EntryString.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.map.EntryString,
      com.google.protobuf.Empty> getPutMethod() {
    io.grpc.MethodDescriptor<srcs.map.EntryString, com.google.protobuf.Empty> getPutMethod;
    if ((getPutMethod = MapStringRemoteGrpc.getPutMethod) == null) {
      synchronized (MapStringRemoteGrpc.class) {
        if ((getPutMethod = MapStringRemoteGrpc.getPutMethod) == null) {
          MapStringRemoteGrpc.getPutMethod = getPutMethod =
              io.grpc.MethodDescriptor.<srcs.map.EntryString, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.map.EntryString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MapStringRemoteMethodDescriptorSupplier("put"))
              .build();
        }
      }
    }
    return getPutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MapStringRemoteStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteStub>() {
        @java.lang.Override
        public MapStringRemoteStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapStringRemoteStub(channel, callOptions);
        }
      };
    return MapStringRemoteStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MapStringRemoteBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteBlockingStub>() {
        @java.lang.Override
        public MapStringRemoteBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapStringRemoteBlockingStub(channel, callOptions);
        }
      };
    return MapStringRemoteBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MapStringRemoteFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapStringRemoteFutureStub>() {
        @java.lang.Override
        public MapStringRemoteFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapStringRemoteFutureStub(channel, callOptions);
        }
      };
    return MapStringRemoteFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MapStringRemoteImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void put(srcs.map.EntryString request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getPutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.google.protobuf.StringValue>(
                  this, METHODID_GET)))
          .addMethod(
            getPutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.map.EntryString,
                com.google.protobuf.Empty>(
                  this, METHODID_PUT)))
          .build();
    }
  }

  /**
   */
  public static final class MapStringRemoteStub extends io.grpc.stub.AbstractAsyncStub<MapStringRemoteStub> {
    private MapStringRemoteStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapStringRemoteStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapStringRemoteStub(channel, callOptions);
    }

    /**
     */
    public void get(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void put(srcs.map.EntryString request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MapStringRemoteBlockingStub extends io.grpc.stub.AbstractBlockingStub<MapStringRemoteBlockingStub> {
    private MapStringRemoteBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapStringRemoteBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapStringRemoteBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.StringValue get(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty put(srcs.map.EntryString request) {
      return blockingUnaryCall(
          getChannel(), getPutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MapStringRemoteFutureStub extends io.grpc.stub.AbstractFutureStub<MapStringRemoteFutureStub> {
    private MapStringRemoteFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapStringRemoteFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapStringRemoteFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.StringValue> get(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> put(
        srcs.map.EntryString request) {
      return futureUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_PUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MapStringRemoteImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MapStringRemoteImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_PUT:
          serviceImpl.put((srcs.map.EntryString) request,
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

  private static abstract class MapStringRemoteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MapStringRemoteBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.map.MapStringRem.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MapStringRemote");
    }
  }

  private static final class MapStringRemoteFileDescriptorSupplier
      extends MapStringRemoteBaseDescriptorSupplier {
    MapStringRemoteFileDescriptorSupplier() {}
  }

  private static final class MapStringRemoteMethodDescriptorSupplier
      extends MapStringRemoteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MapStringRemoteMethodDescriptorSupplier(String methodName) {
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
      synchronized (MapStringRemoteGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MapStringRemoteFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .addMethod(getPutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
