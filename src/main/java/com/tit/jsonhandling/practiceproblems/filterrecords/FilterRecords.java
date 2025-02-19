package com.tit.jsonhandling.practiceproblems.filterrecords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterRecords {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Users\\ASUS\\Desktop\\Day02_JsonHandling\\src\\main\\resources\\students.json";

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            if (jsonNode.isArray()) {
                for (JsonNode student : jsonNode) {
                    int age = student.get("age").asInt(); // Convert "age" to int
                    if (age > 25) {
                        System.out.println(student.toPrettyString());
                    }
                }
            } else {
                int age = jsonNode.get("age").asInt();
                if (age > 25) {
                    System.out.println(jsonNode.toPrettyString());
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid Json!");
            e.printStackTrace();
        }
    }
}
