package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class controller {

    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    // POJO to map the JSON payload
    public static class FileRequest {
        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }

    @PostMapping("/receive-filename")
    public String receiveFileName(@RequestBody FileRequest request) {
        String file = request.getFileName();
        logger.info("Received file name: {}", file);
        return "Received: " + file;
    }
}
