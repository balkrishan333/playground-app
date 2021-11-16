package com.nagpal.bala.playgroundapp.azure;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.specialized.BlockBlobClient;
import com.nagpal.bala.playgroundapp.json.validation.ValidateJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Stream;

public final class BlobStorageApp {

    private static final Logger logger = LoggerFactory.getLogger(BlobStorageApp.class);

    private static final String CONNECTION_STRING_DEV_02 = "DefaultEndpointsProtocol=https;AccountName=odxcentralusappsadev02;AccountKey=bXvgzoX9Sar6LOEbKGr7cLsgpvU9E9fsCajjj+6NgcZ/vC1K/b1nU6HrAtvL7Eqky4MrMShHuNZQBl+5mWWjqQ==;EndpointSuffix=core.windows.net";
    private static final String CONTAINER_NAME = "bala";
    private static final String BLOB_NAME = "Performance.xlsx";

    public static void main(String[] args) {

        //create Blob client
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING_DEV_02)
                                                .buildClient();

        // Get account name
        String accountName = blobServiceClient.getAccountName();
        logger.info("accountName = " + accountName);

        //create container
        //BlobContainerClient containerClient = blobServiceClient.createBlobContainer(CONTAINER_NAME);

        //Get handle to exising container
       // BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);

        //upload file
        /*{
            BlockBlobClient blockBlob = containerClient.getBlobClient(BLOB_NAME).getBlockBlobClient();

            File file = new File("/Users/bnagpal1/temp/CCDs/Performance.xlsx");
            try (InputStream dataStream = new BufferedInputStream(new FileInputStream(file))) {
                blockBlob.upload(dataStream, file.length(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

        //Blob handle to a blob object
      //  BlobClient blobClient = containerClient.getBlobClient(BLOB_NAME);
        //download file
      //  BlobProperties blobProperties1 = blobClient.downloadToFile("/Users/bnagpal1/temp/Performance.xlsx", true);
     //   System.out.println("Metadata =========================");
     //   Stream.of(blobProperties1.getMetadata()).forEach(System.out::println);

        //separate call is required to get content MD5
      //  BlobProperties blobProperties = blobClient.getProperties();
      //  System.out.println("MD 5 = " + Base64.getEncoder().encodeToString(blobProperties.getContentMd5()));

    }
}
