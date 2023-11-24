
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
    "type",
    "onFailureRetries",
    "onFailureRetryInterval",
    "onSubmissionFailureRetries",
    "onSubmissionFailureRetryInterval"
})
@Generated("jsonschema2pojo")
public class RestartPolicy {

    @JsonProperty("type")
    private String type;
    @JsonProperty("onFailureRetries")
    private int onFailureRetries;
    @JsonProperty("onFailureRetryInterval")
    private int onFailureRetryInterval;
    @JsonProperty("onSubmissionFailureRetries")
    private int onSubmissionFailureRetries;
    @JsonProperty("onSubmissionFailureRetryInterval")
    private int onSubmissionFailureRetryInterval;
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

    @JsonProperty("onFailureRetries")
    public int getOnFailureRetries() {
        return onFailureRetries;
    }

    @JsonProperty("onFailureRetries")
    public void setOnFailureRetries(int onFailureRetries) {
        this.onFailureRetries = onFailureRetries;
    }

    @JsonProperty("onFailureRetryInterval")
    public int getOnFailureRetryInterval() {
        return onFailureRetryInterval;
    }

    @JsonProperty("onFailureRetryInterval")
    public void setOnFailureRetryInterval(int onFailureRetryInterval) {
        this.onFailureRetryInterval = onFailureRetryInterval;
    }

    @JsonProperty("onSubmissionFailureRetries")
    public int getOnSubmissionFailureRetries() {
        return onSubmissionFailureRetries;
    }

    @JsonProperty("onSubmissionFailureRetries")
    public void setOnSubmissionFailureRetries(int onSubmissionFailureRetries) {
        this.onSubmissionFailureRetries = onSubmissionFailureRetries;
    }

    @JsonProperty("onSubmissionFailureRetryInterval")
    public int getOnSubmissionFailureRetryInterval() {
        return onSubmissionFailureRetryInterval;
    }

    @JsonProperty("onSubmissionFailureRetryInterval")
    public void setOnSubmissionFailureRetryInterval(int onSubmissionFailureRetryInterval) {
        this.onSubmissionFailureRetryInterval = onSubmissionFailureRetryInterval;
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
