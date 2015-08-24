package fr.hgwood.fanfaron;

import java.util.List;
import java.util.Objects;

public class Operation {
    public List<String> tags;
    public String summary;
    public String description;
    public String operationId;
    public List<String> consumes;
    public List<String> produces;
    public List<Parameter> parameters;
    public Responses responses;
    public List<SecurityRequirement> security;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Operation)) return false;
        Operation other = (Operation)obj;
        return Objects.equals(tags, other.tags)
            && Objects.equals(summary, other.summary)
            && Objects.equals(description, other.description)
            && Objects.equals(operationId, other.operationId)
            && Objects.equals(consumes, other.consumes)
            && Objects.equals(produces, other.produces)
            && Objects.equals(parameters, other.parameters)
            && Objects.equals(responses, other.responses)
            && Objects.equals(tags, other.tags)
            && Objects.equals(security, other.security);
    }

    @Override public int hashCode() {
        return Objects.hash(tags, summary, description, operationId, consumes, parameters, responses, security);
    }
}
