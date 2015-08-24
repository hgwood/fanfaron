package fr.hgwood.fanfaron;

import java.util.List;
import java.util.Objects;

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

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Swagger)) return false;
        Swagger other = (Swagger)obj;
        return Objects.equals(swagger, other.swagger)
            && Objects.equals(info, other.info)
            && Objects.equals(host, other.host)
            && Objects.equals(basePath, other.basePath)
            && Objects.equals(schemes, other.schemes)
            && Objects.equals(paths, other.paths)
            && Objects.equals(definitions, other.definitions)
            && Objects.equals(securityDefinitions, other.securityDefinitions)
            && Objects.equals(tags, other.tags)
            && Objects.equals(externalDocs, other.externalDocs);
    }

    @Override public int hashCode() {
        return Objects.hash(swagger, info, host, basePath, schemes, paths, definitions, securityDefinitions, tags, externalDocs);
    }
}
