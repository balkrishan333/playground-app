
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
    "secretName",
    "shareName",
    "folderName",
    "mountOptions"
})

public class VolumeAttributes {

    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("shareName")
    private String shareName;
    @JsonProperty("folderName")
    private String folderName;
    @JsonProperty("mountOptions")
    private String mountOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("shareName")
    public String getShareName() {
        return shareName;
    }

    @JsonProperty("shareName")
    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    @JsonProperty("folderName")
    public String getFolderName() {
        return folderName;
    }

    @JsonProperty("folderName")
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @JsonProperty("mountOptions")
    public String getMountOptions() {
        return mountOptions;
    }

    @JsonProperty("mountOptions")
    public void setMountOptions(String mountOptions) {
        this.mountOptions = mountOptions;
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
