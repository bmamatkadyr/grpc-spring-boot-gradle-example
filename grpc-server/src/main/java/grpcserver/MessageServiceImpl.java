package grpcserver;

import beksultan.grpc.GiveMeTrueRequest;
import beksultan.grpc.GiveMeTrueResponse;
import beksultan.grpc.Message;
import beksultan.grpc.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {

    @Override
    public void send(Message request, StreamObserver<Message> responseObserver) {
        // create response
        Message message = Message.newBuilder()
                .setMessage("gRPC server received your message: Thank U ❤️ \n Ur message is: " + request.getMessage())
                .build();

        // add to stream observer
        responseObserver.onNext(message);

        // complete
        responseObserver.onCompleted();
    }

    @Override
    public void giveMeTrue(GiveMeTrueRequest request, StreamObserver<GiveMeTrueResponse> responseObserver) {
        responseObserver.onNext(GiveMeTrueResponse.newBuilder().setTrue(true).build());
        responseObserver.onCompleted();
    }
}
