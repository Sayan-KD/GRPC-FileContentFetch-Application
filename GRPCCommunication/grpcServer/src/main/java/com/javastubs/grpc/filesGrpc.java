package com.javastubs.grpc;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: files.proto")
public final class filesGrpc {

  private filesGrpc() {}

  public static final String SERVICE_NAME = "files";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.javastubs.grpc.Files.FetchRequest,
      com.javastubs.grpc.Files.APIResponse> getFetchcontentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchcontents",
      requestType = com.javastubs.grpc.Files.FetchRequest.class,
      responseType = com.javastubs.grpc.Files.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.javastubs.grpc.Files.FetchRequest,
      com.javastubs.grpc.Files.APIResponse> getFetchcontentsMethod() {
    io.grpc.MethodDescriptor<com.javastubs.grpc.Files.FetchRequest, com.javastubs.grpc.Files.APIResponse> getFetchcontentsMethod;
    if ((getFetchcontentsMethod = filesGrpc.getFetchcontentsMethod) == null) {
      synchronized (filesGrpc.class) {
        if ((getFetchcontentsMethod = filesGrpc.getFetchcontentsMethod) == null) {
          filesGrpc.getFetchcontentsMethod = getFetchcontentsMethod = 
              io.grpc.MethodDescriptor.<com.javastubs.grpc.Files.FetchRequest, com.javastubs.grpc.Files.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "files", "fetchcontents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.javastubs.grpc.Files.FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.javastubs.grpc.Files.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new filesMethodDescriptorSupplier("fetchcontents"))
                  .build();
          }
        }
     }
     return getFetchcontentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static filesStub newStub(io.grpc.Channel channel) {
    return new filesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static filesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new filesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static filesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new filesFutureStub(channel);
  }

  /**
   */
  public static abstract class filesImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchcontents(com.javastubs.grpc.Files.FetchRequest request,
        io.grpc.stub.StreamObserver<com.javastubs.grpc.Files.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchcontentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchcontentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.javastubs.grpc.Files.FetchRequest,
                com.javastubs.grpc.Files.APIResponse>(
                  this, METHODID_FETCHCONTENTS)))
          .build();
    }
  }

  /**
   */
  public static final class filesStub extends io.grpc.stub.AbstractStub<filesStub> {
    private filesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private filesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected filesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new filesStub(channel, callOptions);
    }

    /**
     */
    public void fetchcontents(com.javastubs.grpc.Files.FetchRequest request,
        io.grpc.stub.StreamObserver<com.javastubs.grpc.Files.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchcontentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class filesBlockingStub extends io.grpc.stub.AbstractStub<filesBlockingStub> {
    private filesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private filesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected filesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new filesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.javastubs.grpc.Files.APIResponse fetchcontents(com.javastubs.grpc.Files.FetchRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchcontentsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class filesFutureStub extends io.grpc.stub.AbstractStub<filesFutureStub> {
    private filesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private filesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected filesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new filesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.javastubs.grpc.Files.APIResponse> fetchcontents(
        com.javastubs.grpc.Files.FetchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchcontentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCHCONTENTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final filesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(filesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCHCONTENTS:
          serviceImpl.fetchcontents((com.javastubs.grpc.Files.FetchRequest) request,
              (io.grpc.stub.StreamObserver<com.javastubs.grpc.Files.APIResponse>) responseObserver);
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

  private static abstract class filesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    filesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.javastubs.grpc.Files.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("files");
    }
  }

  private static final class filesFileDescriptorSupplier
      extends filesBaseDescriptorSupplier {
    filesFileDescriptorSupplier() {}
  }

  private static final class filesMethodDescriptorSupplier
      extends filesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    filesMethodDescriptorSupplier(String methodName) {
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
      synchronized (filesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new filesFileDescriptorSupplier())
              .addMethod(getFetchcontentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
