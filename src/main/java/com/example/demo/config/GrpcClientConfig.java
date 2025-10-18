package com.example.demo.config;

import com.example.hello.v1.GreeterGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ClientInterceptor;
import io.grpc.stub.AbstractStub;
import io.grpc.Deadline;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class GrpcClientConfig {

  @Value("${grpc.greeter.host}")
  private String host;

  @Value("${grpc.greeter.port}")
  private int port;

  @Value("${grpc.greeter.plaintext:true}")
  private boolean plaintext;

  @Value("${grpc.greeter.deadlineMs:0}")
  private long deadlineMs;

  @Bean(destroyMethod = "shutdownNow")
  public ManagedChannel greeterChannel() {
    ManagedChannelBuilder<?> b = ManagedChannelBuilder.forAddress(host, port);
    if (plaintext) b.usePlaintext();
    return b.build();
  }

  @Bean
  public GreeterGrpc.GreeterBlockingStub greeterBlockingStub(ManagedChannel greeterChannel) {
    GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(greeterChannel);
    if (deadlineMs > 0) {
      stub = stub.withDeadline(Deadline.after(deadlineMs, TimeUnit.MILLISECONDS));
    }
    return stub;
  }
}
