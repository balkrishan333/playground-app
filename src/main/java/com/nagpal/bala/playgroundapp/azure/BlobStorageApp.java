package com.nagpal.bala.playgroundapp.azure;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.specialized.BlockBlobClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public final class BlobStorageApp {

    private static final Logger logger = LoggerFactory.getLogger(BlobStorageApp.class);

    private static final String CONNECTION_STRING_DEV_02 = "<Connection-string-here>";
    private static final String CONTAINER_NAME = "bala";
    private static final String BLOB_NAME = "Performance.xlsx";

    public static void main(String[] args) {

       // variousOperations();
        downloadFileusingURL();

    }

    private static void downloadFileusingURL() {
        BlobClientBuilder blobClientBuilder = new BlobClientBuilder();
        blobClientBuilder.connectionString(CONNECTION_STRING_DEV_02);
        //blobClientBuilder.blobName("las   t");
        blobClientBuilder.endpoint("https://odxcentralusappsadev02.blob.core.windows.net/azure-webjobs-hosts/synctriggers/odx-centralus-dav-fa-dev02/last");
        BlobClient blobClient = blobClientBuilder.buildClient();
        blobClient.downloadToFile("/Users/bnagpal1/temp/url.txt");
        System.out.println("=========== downloaded ===============");
    }

    private static void variousOperations() {
        //create Blob client
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING_DEV_02)
                .buildClient();

        // Get account name
        String accountName = blobServiceClient.getAccountName();
        logger.info("accountName = " + accountName);

        //create container
        //BlobContainerClient containerClient = blobServiceClient.createBlobContainer(CONTAINER_NAME);

        //Get handle to exising container
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);

        //upload file
        {
            BlockBlobClient blockBlob = containerClient.getBlobClient(BLOB_NAME).getBlockBlobClient();

            File file = new File("/Users/bnagpal1/temp/cleanrostertest.csv");
            try (InputStream dataStream = new BufferedInputStream(new FileInputStream(file))) {
                blockBlob.upload(dataStream, file.length(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        {
            PagedIterable<BlobItem> blobItems = containerClient.listBlobs();
            blobItems.forEach(blobItem -> {
                System.out.println("blobItem.getName() = " + blobItem.getName());
            });
        }


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
