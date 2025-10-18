package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UploadController {

  private final S3Client s3Client;

  @Value("${app.s3.bucket}")
  private String bucket;

  @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String upload(@RequestPart("file") MultipartFile file) throws Exception {
    String key = file.getOriginalFilename(); // 必要ならUUIDなどでユニーク化

    PutObjectRequest req = PutObjectRequest.builder()
        .bucket(bucket)
        .key(key)
        .contentType(file.getContentType())
        .build();

      System.out.println("Uploading file to S3: " + key);
      System.out.println("File size: " + file.getSize() + " bytes");
    s3Client.putObject(req, RequestBody.fromBytes(file.getBytes()));
    return "uploaded: s3://" + bucket + "/" + key;
  }
}
