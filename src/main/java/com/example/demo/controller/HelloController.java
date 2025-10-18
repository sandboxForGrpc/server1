package com.example.demo.controller;

import com.example.hello.v1.GreeterGrpc;
import com.example.hello.v1.SayHelloRequest;
import com.example.hello.v1.SayHelloResponse;
import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

  private final GreeterGrpc.GreeterBlockingStub greeter;

  public HelloController(GreeterGrpc.GreeterBlockingStub greeter) {
    this.greeter = greeter;
  }

  // 例: GET /api/hello?name=Rei
  @GetMapping("/api/hello")
  public Map<String, Object> hello(@RequestParam(defaultValue = "world") String name) {
    try {
      SayHelloResponse res = greeter.sayHello(
          SayHelloRequest.newBuilder().setName(name).build()
      );
      return Map.of("message", res.getMessage());
    } catch (StatusRuntimeException e) {
      // よくあるエラー: UNAVAILABLE(接続不可), DEADLINE_EXCEEDED(タイムアウト) など
      throw new HelloUpstreamException("gRPC call failed: " + e.getStatus(), e);
    }
  }

  @ResponseStatus(HttpStatus.BAD_GATEWAY)
  static class HelloUpstreamException extends RuntimeException {
    public HelloUpstreamException(String msg, Throwable cause) { super(msg, cause); }
  }
}
