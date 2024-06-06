
package com.nagpal.bala.playgroundapp.json.k8s;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "pythonVersion",
    "mode",
    "image",
    "imagePullPolicy",
    "timeToLiveSeconds",
    "mainApplicationFile",
    "arguments",
    "sparkVersion",
    "sparkConf",
    "restartPolicy",
    "volumes",
    "driver",
    "executor"
})

public class Spec {

    @JsonProperty("type")
    private String type;
    @JsonProperty("pythonVersion")
    private String pythonVersion;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("timeToLiveSeconds")
    private int timeToLiveSeconds;
    @JsonProperty("mainApplicationFile")
    private String mainApplicationFile;
    @JsonProperty("arguments")
    private List<String> arguments;
    @JsonProperty("sparkVersion")
    private String sparkVersion;
    @JsonProperty("sparkConf")
    private SparkConf sparkConf;
    @JsonProperty("restartPolicy")
    private RestartPolicy restartPolicy;
    @JsonProperty("volumes")
    private List<Volume> volumes;
    @JsonProperty("driver")
    private Driver driver;
    @JsonProperty("executor")
    private Executor executor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("pythonVersion")
    public String getPythonVersion() {
        return pythonVersion;
    }

    @JsonProperty("pythonVersion")
    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("timeToLiveSeconds")
    public int getTimeToLiveSeconds() {
        return timeToLiveSeconds;
    }

    @JsonProperty("timeToLiveSeconds")
    public void setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
    }

    @JsonProperty("mainApplicationFile")
    public String getMainApplicationFile() {
        return mainApplicationFile;
    }

    @JsonProperty("mainApplicationFile")
    public void setMainApplicationFile(String mainApplicationFile) {
        this.mainApplicationFile = mainApplicationFile;
    }

    @JsonProperty("arguments")
    public List<String> getArguments() {
        return arguments;
    }

    @JsonProperty("arguments")
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    @JsonProperty("sparkVersion")
    public String getSparkVersion() {
        return sparkVersion;
    }

    @JsonProperty("sparkVersion")
    public void setSparkVersion(String sparkVersion) {
        this.sparkVersion = sparkVersion;
    }

    @JsonProperty("sparkConf")
    public SparkConf getSparkConf() {
        return sparkConf;
    }

    @JsonProperty("sparkConf")
    public void setSparkConf(SparkConf sparkConf) {
        this.sparkConf = sparkConf;
    }

    @JsonProperty("restartPolicy")
    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonProperty("driver")
    public Driver getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @JsonProperty("executor")
    public Executor getExecutor() {
        return executor;
    }

    @JsonProperty("executor")
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
