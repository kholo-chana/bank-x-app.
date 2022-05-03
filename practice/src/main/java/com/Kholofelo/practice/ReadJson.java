package com.Kholofelo.practice;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        String postedDate = LocalDate.of(2022, 4, 29).toString();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", "100")
                .add("title", "JSON-Processing API Post")
                .add("description", "JSON-Processing API Post")
                .add("postedDate", postedDate);

        JsonObject jsonObject1 = jsonObjectBuilder.build();

        Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory jwf = Json.createWriterFactory(config);
        StringWriter sw = new StringWriter();

        try (JsonWriter jsonWriter = jwf.createWriter(sw)) {
            jsonWriter.writeObject(jsonObject1);
            System.out.println(sw);

        }

//==============================================================================

        //JAVA JSON-P JsonArrayBuilder
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        List<Post> posts = createPosts();
        posts.forEach(post1 -> {

            JsonObject json = Json.createObjectBuilder()
                    .add("id", post1.getId())
                    .add("title", post1.getTitle())
                    .add("description", post1.getDescription())
                    .add("content", post1.getContent()).build();
            jsonArrayBuilder.add(json);
        });

        JsonArray jsonArray1 = jsonArrayBuilder.build();

        try (JsonWriter jsonWriter = jwf.createWriter(sw)) {
            jsonWriter.writeArray(jsonArray1);
            System.out.println(sw);
        }
    }

    public static List < Post > createPosts() {

        List < Post > posts = new ArrayList < > ();
        // create a post
        Post post = new Post();
        post.setTitle("JSONP Tutorial");
        post.setId(100);
        post.setDescription("Post about JSONP");
        post.setContent("HTML content here");

        String[] tags = {
                "Java",
                "JSON"
        };
        // create some predefined tags
        post.setTags(tags);


        // create a post
        Post post1 = new Post();
        post1.setTitle("Jackson Tutorial");
        post1.setId(100);
        post1.setDescription("Post about Jackson API");
        post1.setContent("HTML content here");
        // create some predefined tags
        post1.setTags(new String[] {
                "Java",
                "JSON",
                "Jackson"
        });

        // create a post
        Post post2 = new Post();
        post2.setTitle("Google Gson Tutorial");
        post2.setId(100);
        post2.setDescription("Post about Google Gson");
        post2.setContent("HTML content here");

        // create some predefined tags
        post2.setTags(new String[] {
                "Java",
                "JSON",
                "Gson"
        });

        posts.add(post);
        posts.add(post1);
        posts.add(post2);
        return posts;
    }
}
