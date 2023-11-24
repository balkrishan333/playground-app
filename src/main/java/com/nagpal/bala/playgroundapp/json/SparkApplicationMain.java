package com.nagpal.bala.playgroundapp.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagpal.bala.playgroundapp.json.k8s.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class K8sSparkApplication {
    public static void main(String[] args) throws Exception {
        SparkApplication app = new SparkApplication();

        app.setApiVersion("sparkoperator.k8s.io/v1beta2");
        app.setKind("SparkApplication");
        app.setMetadata(createMetadata());
        app.setSpec(createSpec());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("/Users/bnagpal1/temp/spark-app.json"), app);
    }

    private static Spec createSpec() {
        Spec spec = new Spec();
        spec.setType("Python");
        spec.setPythonVersion("3");
        spec.setMode("cluster");
        spec.setImage("odxbootstrapacr94a636d0.azurecr.io/odx/data-acquisition-roster-validation:v8");
        spec.setImagePullPolicy("Always");
        spec.setTimeToLiveSeconds(3600);
        spec.setMainApplicationFile("local:////opt/spark/work-dir/roster_basic_validation.py");
        spec.setArguments(getArguments());
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

    private static Metadata createMetadata() {
        Metadata metadata = new Metadata();
        metadata.setName("rv-1");
        metadata.setNamespace("bala");

        return metadata;
    }

    private static List<String> getArguments() {
        return List.of("azure-batch",

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
                        "WHBsa29JZEJ6dX5hN0FTdnhFemVUVW1NYlNydzIifQ==");
    }
}
