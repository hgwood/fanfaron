package fr.hgwood.fanfaron;

import java.util.List;

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
}
