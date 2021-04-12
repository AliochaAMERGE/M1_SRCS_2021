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
    comments = "Source: mapRem.proto")
public final class MapRemoteGrpc {

  private MapRemoteGrpc() {}

  public static final String SERVICE_NAME = "srcs.map.MapRemote";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Any,
      com.google.protobuf.Any> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = com.google.protobuf.Any.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Any,
      com.google.protobuf.Any> getGetMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Any, com.google.protobuf.Any> getGetMethod;
    if ((getGetMethod = MapRemoteGrpc.getGetMethod) == null) {
      synchronized (MapRemoteGrpc.class) {
        if ((getGetMethod = MapRemoteGrpc.getGetMethod) == null) {
          MapRemoteGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Any, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new MapRemoteMethodDescriptorSupplier("get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.map.Entry,
      com.google.protobuf.Empty> getPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put",
      requestType = srcs.map.Entry.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.map.Entry,
      com.google.protobuf.Empty> getPutMethod() {
    io.grpc.MethodDescriptor<srcs.map.Entry, com.google.protobuf.Empty> getPutMethod;
    if ((getPutMethod = MapRemoteGrpc.getPutMethod) == null) {
      synchronized (MapRemoteGrpc.class) {
        if ((getPutMethod = MapRemoteGrpc.getPutMethod) == null) {
          MapRemoteGrpc.getPutMethod = getPutMethod =
              io.grpc.MethodDescriptor.<srcs.map.Entry, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.map.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MapRemoteMethodDescriptorSupplier("put"))
              .build();
        }
      }
    }
    return getPutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MapRemoteStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapRemoteStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapRemoteStub>() {
        @java.lang.Override
        public MapRemoteStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapRemoteStub(channel, callOptions);
        }
      };
    return MapRemoteStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MapRemoteBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapRemoteBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapRemoteBlockingStub>() {
        @java.lang.Override
        public MapRemoteBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapRemoteBlockingStub(channel, callOptions);
        }
      };
    return MapRemoteBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MapRemoteFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapRemoteFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MapRemoteFutureStub>() {
        @java.lang.Override
        public MapRemoteFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MapRemoteFutureStub(channel, callOptions);
        }
      };
    return MapRemoteFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MapRemoteImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(com.google.protobuf.Any request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void put(srcs.map.Entry request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getPutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Any,
                com.google.protobuf.Any>(
                  this, METHODID_GET)))
          .addMethod(
            getPutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.map.Entry,
                com.google.protobuf.Empty>(
                  this, METHODID_PUT)))
          .build();
    }
  }

  /**
   */
  public static final class MapRemoteStub extends io.grpc.stub.AbstractAsyncStub<MapRemoteStub> {
    private MapRemoteStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapRemoteStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapRemoteStub(channel, callOptions);
    }

    /**
     */
    public void get(com.google.protobuf.Any request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void put(srcs.map.Entry request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MapRemoteBlockingStub extends io.grpc.stub.AbstractBlockingStub<MapRemoteBlockingStub> {
    private MapRemoteBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapRemoteBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapRemoteBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Any get(com.google.protobuf.Any request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty put(srcs.map.Entry request) {
      return blockingUnaryCall(
          getChannel(), getPutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MapRemoteFutureStub extends io.grpc.stub.AbstractFutureStub<MapRemoteFutureStub> {
    private MapRemoteFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapRemoteFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapRemoteFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Any> get(
        com.google.protobuf.Any request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> put(
        srcs.map.Entry request) {
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
    private final MapRemoteImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MapRemoteImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.google.protobuf.Any) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Any>) responseObserver);
          break;
        case METHODID_PUT:
          serviceImpl.put((srcs.map.Entry) request,
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

  private static abstract class MapRemoteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MapRemoteBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.map.MapRem.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MapRemote");
    }
  }

  private static final class MapRemoteFileDescriptorSupplier
      extends MapRemoteBaseDescriptorSupplier {
    MapRemoteFileDescriptorSupplier() {}
  }

  private static final class MapRemoteMethodDescriptorSupplier
      extends MapRemoteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MapRemoteMethodDescriptorSupplier(String methodName) {
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
      synchronized (MapRemoteGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MapRemoteFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .addMethod(getPutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
