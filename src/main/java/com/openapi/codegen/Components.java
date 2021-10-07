
package com.openapi.codegen;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "schemas",
    "responses",
    "parameters",
    "examples",
    "requestBodies",
    "headers",
    "securitySchemes",
    "links",
    "callbacks"
})
public class Components {

    @JsonProperty("schemas")
    private Schemas schemas;
    @JsonProperty("responses")
    private Responses responses;
    @JsonProperty("parameters")
    private Parameters parameters;
    @JsonProperty("examples")
    private Examples examples;
    @JsonProperty("requestBodies")
    private RequestBodies requestBodies;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("securitySchemes")
    private SecuritySchemes securitySchemes;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("callbacks")
    private Callbacks callbacks;

    @JsonProperty("schemas")
    public Schemas getSchemas() {
        return schemas;
    }

    @JsonProperty("schemas")
    public void setSchemas(Schemas schemas) {
        this.schemas = schemas;
    }

    @JsonProperty("responses")
    public Responses getResponses() {
        return responses;
    }

    @JsonProperty("responses")
    public void setResponses(Responses responses) {
        this.responses = responses;
    }

    @JsonProperty("parameters")
    public Parameters getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("examples")
    public Examples getExamples() {
        return examples;
    }

    @JsonProperty("examples")
    public void setExamples(Examples examples) {
        this.examples = examples;
    }

    @JsonProperty("requestBodies")
    public RequestBodies getRequestBodies() {
        return requestBodies;
    }

    @JsonProperty("requestBodies")
    public void setRequestBodies(RequestBodies requestBodies) {
        this.requestBodies = requestBodies;
    }

    @JsonProperty("headers")
    public Headers getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    @JsonProperty("securitySchemes")
    public SecuritySchemes getSecuritySchemes() {
        return securitySchemes;
    }

    @JsonProperty("securitySchemes")
    public void setSecuritySchemes(SecuritySchemes securitySchemes) {
        this.securitySchemes = securitySchemes;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("callbacks")
    public Callbacks getCallbacks() {
        return callbacks;
    }

    @JsonProperty("callbacks")
    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(schemas).append(responses).append(parameters).append(examples).append(requestBodies).append(headers).append(securitySchemes).append(links).append(callbacks).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Components) == false) {
            return false;
        }
        Components rhs = ((Components) other);
        return new EqualsBuilder().append(schemas, rhs.schemas).append(responses, rhs.responses).append(parameters, rhs.parameters).append(examples, rhs.examples).append(requestBodies, rhs.requestBodies).append(headers, rhs.headers).append(securitySchemes, rhs.securitySchemes).append(links, rhs.links).append(callbacks, rhs.callbacks).isEquals();
    }

}
