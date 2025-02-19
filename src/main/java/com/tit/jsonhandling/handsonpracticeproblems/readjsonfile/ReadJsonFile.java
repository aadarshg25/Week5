package com.tit.jsonhandling.handsonpracticeproblems.readjsonfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> jsonMap = objectMapper.readValue(new File("C:\\Users\\ASUS\\Desktop\\Day02_JsonHandling\\src\\main\\resources\\User.json"), Map.class);

            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

