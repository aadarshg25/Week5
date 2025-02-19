package com.tit.jsonhandling.practiceproblems.studentjson;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        JSONArray subjectArray = new JSONArray();
        subjectArray.put("Physics");
        subjectArray.put("Maths");
        subjectArray.put("Chemistry");


        JSONObject studentJson = new JSONObject();
        studentJson.put("Name" , "Aadarsh");
        studentJson.put("Age" , 21);
        studentJson.put("Subjects" , subjectArray);

        System.out.println(studentJson.toString(1));

    }
}
