package grpcclient;

import beksultan.grpc.MessageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcStubConfig {

    @Bean
    MessageServiceGrpc.MessageServiceBlockingStub configureStub(ManagedChannel managedChannel) {
        return MessageServiceGrpc.newBlockingStub(managedChannel);
    }

    @Bean
    ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", 9191)
                .usePlaintext()
                .build();
    }
}