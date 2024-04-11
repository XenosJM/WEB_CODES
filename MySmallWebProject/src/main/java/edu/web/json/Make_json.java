package edu.web.json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;


public class Make_json {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
        String filePath =  userHome + "\\Desktop\\makePractice.json";
        obj.put("name", "John");
        obj.put("age", 30);
        obj.put("city", "New York");

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

