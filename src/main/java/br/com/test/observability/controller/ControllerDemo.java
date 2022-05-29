package br.com.test.observability.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/v1")

/* how to do https://zetcode.com/springboot/serveimage/ */

public class ControllerDemo {

    @GetMapping(value="/img", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {

        var imgFile = new ClassPathResource("image/finally.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return  ResponseEntity
                             .ok()
                             .contentType(MediaType.IMAGE_JPEG)
                             .body(bytes);
    }

    @GetMapping(value="/msg")
    public ResponseEntity<String> getMsg() {

        String message = "Sucess";

        return  ResponseEntity
                .ok()
                .body(message);
    }

}
