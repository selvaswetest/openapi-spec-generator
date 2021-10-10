package com.openapi.spec.generator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openapi.codegen.model.*;
import com.openapi.spec.generator.utils.JsonSpecGeneratorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class OpenApiSpecCreator {
    private String openapispec;
    private Schema openapischema;
    private String openapiversion;
    private String apiversion;
    private String title;
    private String resourcenames[];
    private ObjectMapper mapper;
    private Info info = new Info();
    private Paths paths = new Paths();
    private Components components;
    private Schemas schemas;
    private String filename;

    public OpenApiSpecCreator(String openapiversion, String apiversion, String title, String resourcenames[]) {
        this.openapiversion = openapiversion;
        this.apiversion = apiversion;
        this.title = title;
        this.resourcenames = resourcenames;
        this.filename="OpenApiSpecification_"+title+".json";
        this.schemas = new Schemas();
        this.components= new Components();
        this.mapper = new ObjectMapper();
        this.openapischema = new Schema();

    }

   void setInfo()
    {
        info.setTitle(this.title);
        info.setVersion(this.apiversion);
    }
    void setPath(){
         Paths paths = new Paths();
    }
    void setComponets(){
        for (String resourcename : resourcenames) {
            try {
                schemas.setAdditionalProperty(JsonSpecGeneratorUtil.getClassNameOnly(resourcename), JsonSpecGeneratorUtil.SchemaGeneratorforClassName(resourcename));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            components.setSchemas(schemas);
        }

    }


   public void OpenApiSpecBuilder() throws IOException, ClassNotFoundException {

        setInfo();
        setPath();
        setComponets();
        openapischema.setOpenapi(this.openapiversion);
        openapischema.setInfo(info);
        openapischema.setPaths(paths);
        openapischema.setComponents(components);
        openapispec = mapper.writeValueAsString(openapischema);
        System.out.println("openapispec :: " + openapispec);
        JsonSpecGeneratorUtil.writeToFile(filename,mapper.writeValueAsString(openapischema));

    };







}
