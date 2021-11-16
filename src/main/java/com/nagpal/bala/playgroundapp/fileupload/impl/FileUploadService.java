package com.nagpal.bala.playgroundapp.fileupload.impl;

import com.nagpal.bala.playgroundapp.AppConfiguration;
import com.nagpal.bala.playgroundapp.fileupload.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileUploadService implements UploadService {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadService.class);

    @Autowired
    private AppConfiguration appConfiguration;

    @Override
    public boolean upload(byte[] file, String fileName) {
        String destinationPath = appConfiguration.getFileUploadPath();

        File target = new File(destinationPath + "/" +fileName);
        LOG.info("Saving file to : {}", target.getAbsolutePath());

        try {
            OutputStream outputStream = new FileOutputStream(target);
            outputStream.write(file);
            LOG.info("File saved.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
