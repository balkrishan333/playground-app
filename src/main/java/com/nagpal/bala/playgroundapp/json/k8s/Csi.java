
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
    "driver",
    "readOnly",
    "volumeAttributes"
})

public class Csi {

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("readOnly")
    private boolean readOnly;
    @JsonProperty("volumeAttributes")
    private VolumeAttributes volumeAttributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("readOnly")
    public boolean isReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("volumeAttributes")
    public VolumeAttributes getVolumeAttributes() {
        return volumeAttributes;
    }

    @JsonProperty("volumeAttributes")
    public void setVolumeAttributes(VolumeAttributes volumeAttributes) {
        this.volumeAttributes = volumeAttributes;
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
