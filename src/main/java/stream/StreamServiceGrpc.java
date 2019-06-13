package stream;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class StreamServiceGrpc {

  private StreamServiceGrpc() {}

  public static final String SERVICE_NAME = "stream.StreamService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi(value = "")
  public static final io.grpc.MethodDescriptor<stream.Stream.RequestData,
      stream.Stream.ResponseData> METHOD_SIMPLE_FUN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "stream.StreamService", "SimpleFun"),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.RequestData.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.ResponseData.getDefaultInstance()));
  @io.grpc.ExperimentalApi(value = "")
  public static final io.grpc.MethodDescriptor<stream.Stream.RequestData,
      stream.Stream.ResponseData> METHOD_SERVER_SIDE_STREAM_FUN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "stream.StreamService", "ServerSideStreamFun"),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.RequestData.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.ResponseData.getDefaultInstance()));
  @io.grpc.ExperimentalApi(value = "")
  public static final io.grpc.MethodDescriptor<stream.Stream.RequestData,
      stream.Stream.ResponseData> METHOD_CLIENT_SIDE_STREAM_FUN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "stream.StreamService", "ClientSideStreamFun"),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.RequestData.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.ResponseData.getDefaultInstance()));
  @io.grpc.ExperimentalApi(value = "")
  public static final io.grpc.MethodDescriptor<stream.Stream.RequestData,
      stream.Stream.ResponseData> METHOD_TWO_WAY_STREAM_FUN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "stream.StreamService", "TwoWayStreamFun"),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.RequestData.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(stream.Stream.ResponseData.getDefaultInstance()));

  public static StreamServiceStub newStub(io.grpc.Channel channel) {
    return new StreamServiceStub(channel);
  }

  public static StreamServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StreamServiceBlockingStub(channel);
  }

  public static StreamServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StreamServiceFutureStub(channel);
  }

  public static interface StreamService {

    public void simpleFun(stream.Stream.RequestData request,
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver);

    public void serverSideStreamFun(stream.Stream.RequestData request,
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver);

    public io.grpc.stub.StreamObserver<stream.Stream.RequestData> clientSideStreamFun(
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver);

    public io.grpc.stub.StreamObserver<stream.Stream.RequestData> twoWayStreamFun(
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver);
  }

  public static interface StreamServiceBlockingClient {

    public stream.Stream.ResponseData simpleFun(stream.Stream.RequestData request);

    public java.util.Iterator<stream.Stream.ResponseData> serverSideStreamFun(
        stream.Stream.RequestData request);
  }

  public static interface StreamServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<stream.Stream.ResponseData> simpleFun(
        stream.Stream.RequestData request);
  }

  public static class StreamServiceStub extends io.grpc.stub.AbstractStub<StreamServiceStub>
      implements StreamService {
    private StreamServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void simpleFun(stream.Stream.RequestData request,
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SIMPLE_FUN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void serverSideStreamFun(stream.Stream.RequestData request,
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SERVER_SIDE_STREAM_FUN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<stream.Stream.RequestData> clientSideStreamFun(
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_CLIENT_SIDE_STREAM_FUN, getCallOptions()), responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<stream.Stream.RequestData> twoWayStreamFun(
        io.grpc.stub.StreamObserver<stream.Stream.ResponseData> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_TWO_WAY_STREAM_FUN, getCallOptions()), responseObserver);
    }
  }

  public static class StreamServiceBlockingStub extends io.grpc.stub.AbstractStub<StreamServiceBlockingStub>
      implements StreamServiceBlockingClient {
    private StreamServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public stream.Stream.ResponseData simpleFun(stream.Stream.RequestData request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SIMPLE_FUN, getCallOptions(), request);
    }

    @java.lang.Override
    public java.util.Iterator<stream.Stream.ResponseData> serverSideStreamFun(
        stream.Stream.RequestData request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SERVER_SIDE_STREAM_FUN, getCallOptions(), request);
    }
  }

  public static class StreamServiceFutureStub extends io.grpc.stub.AbstractStub<StreamServiceFutureStub>
      implements StreamServiceFutureClient {
    private StreamServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<stream.Stream.ResponseData> simpleFun(
        stream.Stream.RequestData request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SIMPLE_FUN, getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE_FUN = 0;
  private static final int METHODID_SERVER_SIDE_STREAM_FUN = 1;
  private static final int METHODID_CLIENT_SIDE_STREAM_FUN = 2;
  private static final int METHODID_TWO_WAY_STREAM_FUN = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreamService serviceImpl;
    private final int methodId;

    public MethodHandlers(StreamService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE_FUN:
          serviceImpl.simpleFun((stream.Stream.RequestData) request,
              (io.grpc.stub.StreamObserver<stream.Stream.ResponseData>) responseObserver);
          break;
        case METHODID_SERVER_SIDE_STREAM_FUN:
          serviceImpl.serverSideStreamFun((stream.Stream.RequestData) request,
              (io.grpc.stub.StreamObserver<stream.Stream.ResponseData>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_SIDE_STREAM_FUN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientSideStreamFun(
              (io.grpc.stub.StreamObserver<stream.Stream.ResponseData>) responseObserver);
        case METHODID_TWO_WAY_STREAM_FUN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.twoWayStreamFun(
              (io.grpc.stub.StreamObserver<stream.Stream.ResponseData>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final StreamService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_SIMPLE_FUN,
          asyncUnaryCall(
            new MethodHandlers<
              stream.Stream.RequestData,
              stream.Stream.ResponseData>(
                serviceImpl, METHODID_SIMPLE_FUN)))
        .addMethod(
          METHOD_SERVER_SIDE_STREAM_FUN,
          asyncServerStreamingCall(
            new MethodHandlers<
              stream.Stream.RequestData,
              stream.Stream.ResponseData>(
                serviceImpl, METHODID_SERVER_SIDE_STREAM_FUN)))
        .addMethod(
          METHOD_CLIENT_SIDE_STREAM_FUN,
          asyncClientStreamingCall(
            new MethodHandlers<
              stream.Stream.RequestData,
              stream.Stream.ResponseData>(
                serviceImpl, METHODID_CLIENT_SIDE_STREAM_FUN)))
        .addMethod(
          METHOD_TWO_WAY_STREAM_FUN,
          asyncBidiStreamingCall(
            new MethodHandlers<
              stream.Stream.RequestData,
              stream.Stream.ResponseData>(
                serviceImpl, METHODID_TWO_WAY_STREAM_FUN)))
        .build();
  }
}
