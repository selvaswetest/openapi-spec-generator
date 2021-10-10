package com;

import com.openapi.spec.generator.service.OpenApiSpecCreator;

import java.io.IOException;


public class Exec {
    public static void main(String[] args) {

        try {
            String classarray[] = {"com.avro.codegen.model.User"};
            OpenApiSpecCreator apispec = new OpenApiSpecCreator("3.0.0", "0.0.1", "credit_report_0.1", classarray);
            apispec.OpenApiSpecBuilder();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
