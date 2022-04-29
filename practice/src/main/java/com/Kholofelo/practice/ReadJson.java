package com.Kholofelo.practice;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReadJson {

    public static void main(String[] main) throws IOException {

        InputStream fis = new FileInputStream("C:\\Users\\Kholofelo\\Documents\\practice\\practice\\practice\\src\\main\\resources\\static\\posts.json");

        // create JsonReader object
        JsonReader jsonReader = Json.createReader(fis);

        // get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        fis.close();

        // Retrieve data from JsonObject and create Post bean
        Post post = new Post();
        post.setId(jsonObject.getInt("id"));
        post.setTitle(jsonObject.getString("title"));
        post.setDescription(jsonObject.getString("description"));
        post.setContent(jsonObject.getString("content"));

        // reading arrays from json
        JsonArray jsonArray = jsonObject.getJsonArray("tags");
        String[] tags = new String[jsonArray.size()];
        int index = 0;
        for (JsonValue value : jsonArray) {
            tags[index++] = value.toString();
        }
        post.setTags(tags);
        // print post object
        System.out.println(post.toString());

//=========================================================================================

        //JAVA JSON-P JsonObjectBuilder
        String postedDate = LocalDate.of(2022,4,29).toString();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id","100")
                .add("title","JSON-Processing API Post")
                .add("description","JSON-Processing API Post")
                .add("postedDate",postedDate);

        JsonObject jsonObject1 = jsonObjectBuilder.build();

        Map<String, Boolean> config = new HashMap<String,Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING,true);

        JsonWriterFactory jwf = Json.createWriterFactory(config);
        StringWriter sw = new StringWriter();

        try(JsonWriter jsonWriter = jwf.createWriter(sw)){
            jsonWriter.writeObject(jsonObject1);
            System.out.println(sw);

        }

//==============================================================================

        //JAVA JSON-P JsonObjectBuilder





    }
}
