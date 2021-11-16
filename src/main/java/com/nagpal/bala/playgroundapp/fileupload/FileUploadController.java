package com.nagpal.bala.playgroundapp.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
        LOG.info("Starting file upload...");
        LOG.info("File name: {}, size: {} bytes", file.getOriginalFilename(), file.getSize());

        boolean result;
        String message = "Upload Failed.";
        try {
           result  = uploadService.upload(file.getBytes(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        if (result) {
            message = "Upload success";
        }
        return ResponseEntity.ok(message);
    }
}
