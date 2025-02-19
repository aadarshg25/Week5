package com.tit.jsonhandling.practiceproblems.validatejson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper jsonObj = new ObjectMapper();
        String filePath = "C:\\Users\\ASUS\\Desktop\\Day02_JsonHandling\\src\\main\\resources\\User.json";
        try {
            JsonNode jsonNode = jsonObj.readTree(new File(filePath));
            System.out.println("Valid JSON: " + jsonNode.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid Json!");
        }

    }
}
