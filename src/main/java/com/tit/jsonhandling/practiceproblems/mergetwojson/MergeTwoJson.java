package com.tit.jsonhandling.practiceproblems.mergetwojson;

import org.json.JSONObject;

public class MergeTwoJson {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("Id","001");
        obj1.put("Name","brook");
        obj1.put("Age",21);

        JSONObject obj2 = new JSONObject();
        obj2.put("email","isagi@gmail.com");
        obj2.put("Country","India");
        obj2.put("Marks",95);


        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        System.out.println("Merged JSON Object:");
        System.out.println(obj1.toString(4));
    }
}
