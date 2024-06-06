
package com.nagpal.bala.playgroundapp.json.k8s;

import java.util.LinkedHashMap;
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
    "spark.eventLog.enabled",
    "spark.eventLog.dir",
    "spark.history.fs.logDirectory",
    "spark.driver.extraJavaOptions"
})

public class SparkConf {

    @JsonProperty("spark.eventLog.enabled")
    private String sparkEventLogEnabled;
    @JsonProperty("spark.eventLog.dir")
    private String sparkEventLogDir;
    @JsonProperty("spark.history.fs.logDirectory")
    private String sparkHistoryFsLogDirectory;
    @JsonProperty("spark.driver.extraJavaOptions")
    private String sparkDriverExtraJavaOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("spark.eventLog.enabled")
    public String getSparkEventLogEnabled() {
        return sparkEventLogEnabled;
    }

    @JsonProperty("spark.eventLog.enabled")
    public void setSparkEventLogEnabled(String sparkEventLogEnabled) {
        this.sparkEventLogEnabled = sparkEventLogEnabled;
    }

    @JsonProperty("spark.eventLog.dir")
    public String getSparkEventLogDir() {
        return sparkEventLogDir;
    }

    @JsonProperty("spark.eventLog.dir")
    public void setSparkEventLogDir(String sparkEventLogDir) {
        this.sparkEventLogDir = sparkEventLogDir;
    }

    @JsonProperty("spark.history.fs.logDirectory")
    public String getSparkHistoryFsLogDirectory() {
        return sparkHistoryFsLogDirectory;
    }

    @JsonProperty("spark.history.fs.logDirectory")
    public void setSparkHistoryFsLogDirectory(String sparkHistoryFsLogDirectory) {
        this.sparkHistoryFsLogDirectory = sparkHistoryFsLogDirectory;
    }

    @JsonProperty("spark.driver.extraJavaOptions")
    public String getSparkDriverExtraJavaOptions() {
        return sparkDriverExtraJavaOptions;
    }

    @JsonProperty("spark.driver.extraJavaOptions")
    public void setSparkDriverExtraJavaOptions(String sparkDriverExtraJavaOptions) {
        this.sparkDriverExtraJavaOptions = sparkDriverExtraJavaOptions;
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
