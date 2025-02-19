package com.tit.jsonhandling.practiceproblems.extractspecificfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ExtractSpecificFields {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\ASUS\\Desktop\\Day02_JsonHandling\\src\\main\\resources\\User.json";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            System.out.println("Name : " +jsonNode.get("name"));
            System.out.println("Email : " + jsonNode.get("email"));

        } catch (Exception e) {
            System.out.println("UnExpected Termination!");
            System.out.println(e.getMessage());
        }

    }
}
