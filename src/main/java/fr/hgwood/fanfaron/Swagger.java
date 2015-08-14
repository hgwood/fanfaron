package fr.hgwood.fanfaron;

import java.util.List;

public class Swagger {
    public String swagger;
    public Info info;
    public String host;
    public String basePath;
    public List<String> schemes;
    public Paths paths;
    public Definitions definitions;
    public SecurityDefinitions securityDefinitions;
    public List<Tag> tags;
    public ExternalDocumentation externalDocs;
}
