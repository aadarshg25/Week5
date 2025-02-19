package com.tit.jsonhandling.practiceproblems.convertlisttojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ConvertListToJsonArray {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice" ,21));
        users.add(new User("Brook" ,22));
        users.add(new User("Reo" ,25));
        users.add(new User("Nami" ,18));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String usersJson = objectMapper.writeValueAsString(users);
            System.out.println(usersJson);
        } catch (Exception e) {
            System.out.println("Invalid Json!");
        }

    }
}
