package com.nagpal.bala.playgroundapp.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagpal.bala.playgroundapp.json.k8s.*;
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
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.http.HttpHeaders;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class SparkApplicationMain {

    private static final String JWT_TOKEN =
            "eyJhbGciOiJSUzI1NiIsImtpZCI6IjRIRXQ2WXBmU2tzVjVoQ1ltZ3ZUNEpQY21lMlp4ZXBESTlIcjJDb3NLNHcifQ." +
                    "eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3Vu" +
                    "dC9uYW1lc3BhY2UiOiJiYWxhIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6Im" +
                    "FwaS1zZXJ2aWNlLWFjY291bnQtdG9rZW4iLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2" +
                    "UtYWNjb3VudC5uYW1lIjoiYXBpLXNlcnZpY2UtYWNjb3VudCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291" +
                    "bnQvc2VydmljZS1hY2NvdW50LnVpZCI6ImE4ZDAwNzUwLWQwZDItNDVmZS04YWY4LThkODA4YWM4ZjBhYiIsI" +
                    "nN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpiYWxhOmFwaS1zZXJ2aWNlLWFjY291bnQifQ.JRfz_sazMD" +
                    "Vxbfh4qIBu10u11EACQZnQNpFxO5Hfy0KkEBHwqpw0f6HpAZyEQbaw3sXlVzAPaRuxJC5M9BBsMA8h8NRb06Uv" +
                    "c204EhRfb_YZqym2m7RR7kKm5N5vO4YYZ9hXcjmdqyScxOBRwXc9mrZT7J_GqkBYA_XCCuUm9X2qGoOF9Dxw9ben" +
                    "kOlOE76VqmmtfSi4zAfgjd9c-Vp8MOwXVFZ2spskSGyCBKkNQwI9n9cYNZu2Y_w-Teyhq92VV-aC0_WUbHfNm-L" +
                    "WDPiRMWEid3mBXylT6wr1E-hKh265pJvptBSrKbPg9kWcb9LxYVrLQl57QR4_pv9XfR0Ucd64C3dfgv7N7syGGj5" +
                    "iPCY6o-M3W8BrATPyOyzmGfLA974Vk7fDBRBSzzZu-2PKNwI8IoJioytGMiG2SMRsWFLWXGZfInOjLXwfgmWHA8M" +
                    "cFp795UgZYVYZCqXqVmadhLZNnjx3WsNcWXMcLz4AreWvCYQJHJ18EebsdC0v3LWiZvR7iOAXwuIMskO4jxyi" +
                    "622fEzhBvrLAraKUW6h1ccZe7KXvgjgYmdfsOQ1pcTGHKH56L6slreeHMTS9Dbu_Ddi4jHQ8WnHNRkBihLL04cucd" +
                    "vBpfpnPPK7jSKP7gGeBPZcG8DkUGSN96pmX4wCGZBL29Pw83udXaITCNLDURHg";

    public static void main(String[] args) throws Exception {
        SparkApplication app = new SparkApplication();

        app.setApiVersion("sparkoperator.k8s.io/v1beta2");
        app.setKind("SparkApplication");
        app.setMetadata(createMetadata("rv-1", "bala"));
        app.setSpec(createSpec("odxbootstrapacr94a636d0.azurecr.io/odx/data-acquisition-roster-validation:v8",

                "eyJjbGllbnRPcmdJZCI6MjAyMDAxLCJ0ZW5hbnRJZCI6MjMwMDI0MiwiY2xpZW50T3JkZXJJZCI6MTU0Miwicm9zdGVy" +
                        "SWQiOjE1MTEsInZlbmRvcnMiOlt7ImRhdGFWZW5kb3JPcmdJZCI6MjAwMTExLCJkYXRhVmVuZG9yT3JnTmFtZ" +
                        "SI6IkF0aGVuYSIsInZlbmRvck9yZGVySWQiOjE2ODV9XSwicm9zdGVyRmlsZU5hbWUiOiJOQ0NfU2FtcGxlX1Rl" +
                        "c3QgLSBWMiAtIEVJTVAgLSBET0IgY2hlY2suY3N2Iiwicm9zdGVyRmlsZVBhdGgiOiJyb3N0ZXJzLzIwMjMvMD" +
                        "YvMDkvMTU0MiIsInJvc3RlclR5cGUiOiJPUklHSU5BTCIsIm9yaWdpbmFsUm9zdGVyRmlsZVZlcnNpb24iOiJWM" +
                        "iIsInVwZGF0ZU9yaWdpbmFsUm9zdGVyIjpmYWxzZX0=",

                "eyJCQVRDSF9DTElFTlRfSUQiOiIyNTc1MmI1NC01OTJlLTQ3MzctODhmOC1mZmZhMTdlNzg0NmQiLCJDT05GSUdfU0VSVklDRV" +
                        "9JU1RJT19VUkwiOiJodHRwOi8vaXN0aW8uZGV2MTEub2R4LW5vbnByb2QubzM2MC5jbG91ZC9jb25maWctc2VydmljZS" +
                        "IsIkJBVENIX1RFTkFOVF9JRCI6ImRiMDVmYWNhLWM4MmEtNGI5ZC1iOWM1LTBmNjRiNjc1NTQyMSIsIktFWV9WQVVMVF" +
                        "9VUkwiOiJodHRwczovL29keC1jZW50cmFsdXMta3YtZGV2MTEudmF1bHQuYXp1cmUubmV0LyIsIngtaGVhZGVyLWV2ZW" +
                        "50LWlkIjoidzphZjAzNmFiNi00ZWZkLTQyNDUtOWM4Ny1lOGExMTNiZmViZGYiLCJTUExVTktfSU5ERVgiOiJvZHhfYX" +
                        "BwbGljYXRpb25fbm9uX3Byb2QiLCJQVUxTQVJfTE9HR0VSX0xFVkVMIjoiSU5GTyIsIkVOVklST05NRU5UX05BTUUiOiJ" +
                        "kZXYxMSIsIlNQTFVOS19IRUNfVE9LRU4iOiJlZTY0ZWFkYi1kZGYzLTRlOTktYjI0MC02Y2U2MzgxZWZmZDciLCJFTkF" +
                        "CTEVfVkFMSURBVElPTl9ST1VUSU5FX1NQTFVOSyI6ImZhbHNlIiwiQkFUQ0hfSk9CX0xPR0dFUl9MRVZFTCI6IklORk8" +
                        "iLCJTUExVTktfVVJMIjoiaHR0cHM6Ly9zcGx1bmsubzM2MC5jbG91ZCIsIkJBVENIX1NFQ1JFVF9JRCI6InFNODdRfmJF" +
                        "WHBsa29JZEJ6dX5hN0FTdnhFemVUVW1NYlNydzIifQ=="

                ));

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("/Users/bnagpal1/temp/spark-app.json"), app);
        String jsonContent = objectMapper.writeValueAsString(app);
        System.out.println(jsonContent);

//        submitAppToCluster();
    }

    private static void submitAppToCluster() throws Exception {

        final boolean disableSSLVerification = true;
        final boolean useFileEntity = true;

        final HttpPost httpPost;

        HttpEntity entity;
        if (useFileEntity) {

            //httpPost = new HttpPost("https://20.40.246.221/api/v1/namespaces/default/pods");
            httpPost = new HttpPost("https://20.40.246.221/apis/sparkoperator.k8s.io/v1beta2/namespaces/bala/sparkapplications");

            entity = new FileEntity(new File("/Users/bnagpal1/temp/post-rest-api-data/spark-app.json"),
                    ContentType.APPLICATION_JSON);
        } else {

            httpPost = new HttpPost("http://localhost:5000/countries");
            final String json = "{\n" +
                    "        \"area\": 513120,\n" +
                    "        \"capital\": \"London\",\n" +
                    "        \"name\": \"England\"\n" +
                    "    }";

            entity = new StringEntity(json);
        }

        httpPost.setEntity(entity);

        final String authHeader = "Bearer" + " " + JWT_TOKEN;
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        final boolean skipSSLVerification = true;

        if (skipSSLVerification) {
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
                System.out.println("statusCode = " + statusCode);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            try (CloseableHttpClient client = HttpClients.custom().build();
                 CloseableHttpResponse response = client.execute(httpPost)) {
                final int statusCode = response.getCode();
                System.out.println("statusCode = " + statusCode);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static Spec createSpec(final String image, final String payload, final String envVariables) {
        Spec spec = new Spec();
        spec.setType("Python");
        spec.setPythonVersion("3");
        spec.setMode("cluster");
        spec.setImage(image);
        spec.setImagePullPolicy("Always");
        spec.setTimeToLiveSeconds(3600);
        spec.setMainApplicationFile("local:////opt/spark/work-dir/roster_basic_validation.py");

        spec.setArguments(getArguments(payload, envVariables));

        spec.setSparkVersion("3.3.0");
        spec.setSparkConf(createSparkConf());
        spec.setRestartPolicy(createRestartPolicy());
        spec.setVolumes(createVolumes());
        spec.setDriver(createDriver());
        spec.setExecutor(createExecutor());

        return spec;
    }

    private static Executor createExecutor() {
        Executor executor = new Executor();
        executor.setCores(4);
        executor.setInstances(4);
        executor.setMemory("2048m");
        executor.setLabels(getLabels());
        executor.setVolumeMounts(getVolumeMount());

        return executor;
    }

    private static Driver createDriver() {
        Driver driver = new Driver();
        driver.setCores(1);
        driver.setCoreLimit("1200m");
        driver.setMemory("2048m");
        driver.setLabels(getLabels());
        driver.setServiceAccount("my-release-spark");
        driver.setVolumeMounts(getVolumeMount());

        return driver;
    }

    @NotNull
    private static List<VolumeMount> getVolumeMount() {
        VolumeMount volumeMount = new VolumeMount();
        volumeMount.setMountPath("/mnt/azure");
        volumeMount.setName("azure-disk");
        return List.of(volumeMount);
    }

    @NotNull
    private static Labels getLabels() {
        Labels labels = new Labels();
        labels.setVersion("3.3.0");
        return labels;
    }

    private static List<Volume> createVolumes() {
        Volume volume = new Volume();
        volume.setName("azure-disk");
        volume.setCsi(createCsi());

        return List.of(volume);
    }

    private static Csi createCsi() {
        Csi csi = new Csi();
        csi.setDriver("file.csi.azure.com");
        csi.setReadOnly(false);

        VolumeAttributes volumeAttributes = new VolumeAttributes();
        volumeAttributes.setSecretName("azure-secret");
        volumeAttributes.setShareName("certshare");
        volumeAttributes.setFolderName("logs");
        volumeAttributes.setMountOptions("dir_mode=0777,file_mode=0777,cache=none,actimeo=30,nosharesock");

        csi.setVolumeAttributes(volumeAttributes);

        return csi;
    }

    private static RestartPolicy createRestartPolicy() {
        RestartPolicy policy = new RestartPolicy();
        policy.setType("OnFailure");
        policy.setOnFailureRetries(3);
        policy.setOnFailureRetryInterval(10);
        policy.setOnSubmissionFailureRetryInterval(20);
        policy.setOnSubmissionFailureRetries(5);

        return policy;
    }

    private static SparkConf createSparkConf() {
        SparkConf conf = new SparkConf();
        conf.setSparkEventLogEnabled("true");
        conf.setSparkEventLogDir("file:/mnt/azure");
        conf.setSparkHistoryFsLogDirectory("file:/mnt/azure");
        conf.setSparkDriverExtraJavaOptions("-Dlog4j.configuration=file:///opt/spark/work-dir/log4j2.properties");

        return conf;
    }

    private static Metadata createMetadata(final String taskName, final String namespace) {
        Metadata metadata = new Metadata();
        metadata.setName(taskName);
        metadata.setNamespace(namespace);

        return metadata;
    }

    private static List<String> getArguments(final String payload, final String envVariables) {
        return List.of("azure-batch", payload, envVariables);
    }
}
