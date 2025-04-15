package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class controller {

    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    // POJO to map the JSON payload
    public class FileListRequest {
        private List<String> fileNames;

        public List<String> getFileNames() {
            return fileNames;
        }

        public void setFileNames(List<String> fileNames) {
            this.fileNames = fileNames;
        }
    }

    @PostMapping("/receive-filename")
    public ResponseEntity<Object> receiveFileName(@RequestBody FileListRequest request) {

        List<String> fileNames = request.getFileNames();

        if (fileNames != null && !fileNames.isEmpty()) {
            logger.info("Received file names:");
            fileNames.forEach(name -> logger.info(" - {}", name));
        } else {
            logger.warn(" No file names received in the request.");
        }

        return ResponseEntity.ok().build();
    }
}
