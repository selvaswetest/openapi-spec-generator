package com.openapi.spec.generator.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonSpecGeneratorUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getClassNameOnly(String clsname) {
        int mid = clsname.lastIndexOf('.') + 1;
        return clsname.substring(mid).toLowerCase();
    }


    public static JsonNode SchemaGeneratorforClassName(String resource_class_name) throws ClassNotFoundException {

        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(mapper, SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON);
        configBuilder.without(Option.SCHEMA_VERSION_INDICATOR);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema;
        Class classname = Class.forName(resource_class_name);
        jsonSchema = generator.generateSchema(classname);
        return jsonSchema;
    }


    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    public static List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public Map generateViaVictoolsJsonSchmaforPackage(String packageName) {
        List<Class> classes;
        Map schmaObjMap =new HashMap();
        try {
            SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(
                    SchemaVersion.DRAFT_2019_09,
                    OptionPreset.PLAIN_JSON
            );

            SchemaGeneratorConfig config = configBuilder.build();
            SchemaGenerator generator = new SchemaGenerator(config);

            classes = getClasses(packageName);
            schmaObjMap =new HashMap();
            for (Class cls : classes) {
                System.out.println( "class Name ::::" + cls.getName());
           }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return schmaObjMap;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);

        List<File> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<Class> classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    public void writeToFile(String filename, Object node) throws IOException {
        Files.writeString(
                Path.of("output/" + filename),
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node)
        );

    }
    public static void writeToFile(String filename, String data) throws IOException {
        Files.writeString(     Path.of("output/" + filename),
                data
        );

    }



}