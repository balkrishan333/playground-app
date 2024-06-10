package com.nagpal.bala.playgroundapp.k8s;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.http.HttpHeaders;
import org.springframework.http.MediaType;

@Data
@Log4j2
public class CreatePod {

    private final String apiServer;
    private final String jsonPayload;
    private final String namespace;
    private final String token;

    private final static String URL = "/api/v1/namespaces/{namespace}/pods";

    public CreatePod(String apiServer, String jsonPayload, String token) {
        this(apiServer, jsonPayload, "default", token);
    }

    public CreatePod(String apiServer, String jsonPayload, String namespace, String token) {
        this.apiServer = apiServer;
        this.jsonPayload = jsonPayload;
        this.namespace = StringUtils.isEmpty(namespace) ? "default" : namespace;
        this.token = token;
    }

    public void create() {
        log.info("Creating pod...");
        log.info("apiServer = {}", apiServer);
        log.info("jsonPayload = {}", jsonPayload);

        final HttpPost httpPost = new HttpPost("https://" + apiServer + URL.replace("{namespace}", namespace));
        HttpEntity entity = new StringEntity(jsonPayload, ContentType.APPLICATION_JSON);

        log.info("URL : {}", httpPost.toString());

        httpPost.setEntity(entity);
        final String authHeader = "Bearer" + " " + token;
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


        try (CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
                                .setSslContext(SSLContextBuilder.create()
                                        .loadTrustMaterial(TrustAllStrategy.INSTANCE)
                                        .build())
                                .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                                .build())
                        .build())
                .build();
             CloseableHttpResponse response = client.execute(httpPost)) {
            final int statusCode = response.getCode();
            log.info("submitted app to the cluster with status {}", statusCode);
        } catch (Exception exception) {
            log.error(exception);
            throw new RuntimeException("Pod creation failed.");
        }
        log.info("Pod creation successful.");
    }

}
