
package com.openapi.codegen;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enum",
    "default",
    "description"
})
public class VariablesProperty {

    @JsonProperty("enum")
    private List<String> _enum = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("default")
    private String _default;
    @JsonProperty("description")
    private String description;

    @JsonProperty("enum")
    public List<String> getEnum() {
        return _enum;
    }

    @JsonProperty("enum")
    public void setEnum(List<String> _enum) {
        this._enum = _enum;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("default")
    public String getDefault() {
        return _default;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("default")
    public void setDefault(String _default) {
        this._default = _default;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_enum).append(_default).append(description).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VariablesProperty) == false) {
            return false;
        }
        VariablesProperty rhs = ((VariablesProperty) other);
        return new EqualsBuilder().append(_enum, rhs._enum).append(_default, rhs._default).append(description, rhs.description).isEquals();
    }

}
