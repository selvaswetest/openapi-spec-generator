
package com.openapi.codegen;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Validation schema for OpenAPI Specification 3.0.X.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openapi",
    "info",
    "externalDocs",
    "servers",
    "security",
    "tags",
    "paths",
    "components"
})
public class Schema {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("openapi")
    private String openapi;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("info")
    private Info info;
    @JsonProperty("externalDocs")
    private ExternalDocs externalDocs;
    @JsonProperty("servers")
    private List<Server> servers = new ArrayList<Server>();
    @JsonProperty("security")
    private List<Security> security = new ArrayList<Security>();
    @JsonProperty("tags")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<Tag> tags = new LinkedHashSet<Tag>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("paths")
    private Paths paths;
    @JsonProperty("components")
    private Components components;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("openapi")
    public String getOpenapi() {
        return openapi;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("openapi")
    public void setOpenapi(String openapi) {
        this.openapi = openapi;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("externalDocs")
    public ExternalDocs getExternalDocs() {
        return externalDocs;
    }

    @JsonProperty("externalDocs")
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs = externalDocs;
    }

    @JsonProperty("servers")
    public List<Server> getServers() {
        return servers;
    }

    @JsonProperty("servers")
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @JsonProperty("security")
    public List<Security> getSecurity() {
        return security;
    }

    @JsonProperty("security")
    public void setSecurity(List<Security> security) {
        this.security = security;
    }

    @JsonProperty("tags")
    public Set<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("paths")
    public Paths getPaths() {
        return paths;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("paths")
    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    @JsonProperty("components")
    public Components getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(Components components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(openapi).append(info).append(externalDocs).append(servers).append(security).append(tags).append(paths).append(components).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Schema) == false) {
            return false;
        }
        Schema rhs = ((Schema) other);
        return new EqualsBuilder().append(openapi, rhs.openapi).append(info, rhs.info).append(externalDocs, rhs.externalDocs).append(servers, rhs.servers).append(security, rhs.security).append(tags, rhs.tags).append(paths, rhs.paths).append(components, rhs.components).isEquals();
    }

}
