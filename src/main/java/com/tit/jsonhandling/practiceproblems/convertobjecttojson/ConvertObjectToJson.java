package com.tit.jsonhandling.practiceproblems.convertobjecttojson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class ConvertObjectToJson {
    public static void main(String[] args) {
        try{
            Car car = new Car("BMW" ,"BMXX001",2002);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(car);
            JSONObject carJson = new JSONObject(jsonString);
            System.out.println(carJson.toString(4));
        } catch (Exception e) {
            System.out.println("Unexpected Json Conversion!");
        }

    }
}
