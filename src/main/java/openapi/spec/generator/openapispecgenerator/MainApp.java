package openapi.spec.generator.openapispecgenerator;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openapi.codegen.Components;
import com.openapi.codegen.Info;
import com.openapi.codegen.Schema;
import com.openapi.codegen.Schemas;
import openapi.spec.generator.openapispecgenerator.utils.AvroToJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.io.IOException;

public class MainApp {

    public static  void  main (String agr[]) throws JsonProcessingException {
        Model model = new ConcurrentModel();
        Model name = model.addAttribute("name", "selva");
        System.out.println(   "openapi_3_0_0_template");
        System.out.println("hello");


       /*  ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

       // Java object to JSON file
        try {

            mapper.writeValue(new File("C:\\workspace\\openapi_gernarted.json"), user);
            // Java object to JSON string
            String jsonString = mapper.writeValueAsString(user);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        String infile ="C:\\workspace\\Avro_POC\\user.avsc";
        String outfile=  "C:\\workspace\\user.json";

        AvroToJsonUtil avroToJsonUtill =new AvroToJsonUtil();
        String json = avroToJsonUtill.convertAvroToJson(infile,outfile);
        System.out.println("json ::::  " + json);

        String processed = StringUtils.replace(json, "definitions", "components");
        System.out.println("processed ::::  " + processed);

      com.openapi.codegen.Schema openapischema = new Schema();
      openapischema.setOpenapi("3.0.3");

       Info info= new Info();
       info.setTitle("Credit Report Swagger");
       info.setVersion("0.0.1");

       openapischema.setInfo(info);

        ObjectMapper mapper = new ObjectMapper();

        Components components = new Components();
        Schemas schemas=new Schemas();





        openapischema.setComponents(components);

        String jsonString = mapper.writeValueAsString(openapischema);
        System.out.println(jsonString);
    }
}
