
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
    "cores",
    "instances",
    "memory",
    "labels",
    "volumeMounts"
})
@Generated("jsonschema2pojo")
public class Executor {

    @JsonProperty("cores")
    private int cores;
    @JsonProperty("instances")
    private int instances;
    @JsonProperty("memory")
    private String memory;
    @JsonProperty("labels")
    private Labels__1 labels;
    @JsonProperty("volumeMounts")
    private List<VolumeMount__1> volumeMounts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cores")
    public int getCores() {
        return cores;
    }

    @JsonProperty("cores")
    public void setCores(int cores) {
        this.cores = cores;
    }

    @JsonProperty("instances")
    public int getInstances() {
        return instances;
    }

    @JsonProperty("instances")
    public void setInstances(int instances) {
        this.instances = instances;
    }

    @JsonProperty("memory")
    public String getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(String memory) {
        this.memory = memory;
    }

    @JsonProperty("labels")
    public Labels__1 getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels__1 labels) {
        this.labels = labels;
    }

    @JsonProperty("volumeMounts")
    public List<VolumeMount__1> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount__1> volumeMounts) {
        this.volumeMounts = volumeMounts;
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
