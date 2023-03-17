package grpcclient;

import beksultan.grpc.GiveMeTrueRequest;
import beksultan.grpc.GiveMeTrueResponse;
import beksultan.grpc.Message;
import beksultan.grpc.MessageServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GrpcClient("grpc-server")
    private MessageServiceGrpc.MessageServiceBlockingStub messageStub;

    @GetMapping("/greetings")
    Message send() {
        return this.messageStub.send(Message.newBuilder().setMessage("Hello from REST").build());
    }

    @GetMapping("/give-me-true")
    GiveMeTrueResponse giveMeTrue() {
        return this.messageStub.giveMeTrue(GiveMeTrueRequest.getDefaultInstance());
    }
}
