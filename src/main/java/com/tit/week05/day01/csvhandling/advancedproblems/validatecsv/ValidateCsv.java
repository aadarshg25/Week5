package com.tit.week05.day01.csvhandling.advancedproblems.validatecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\CompanyData.csv";
        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$");
        Pattern patternPhone = Pattern.compile("^(\\+?[0-9]{1,3})?[- ]?[0-9]{10}$");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int emailCol = -1;
            int phoneCol = -1;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");

                if (isHeader) {
                    for (int i = 0; i < col.length; i++) {
                        if (col[i].equalsIgnoreCase("email")) {
                            emailCol = i;
                        }if (col[i].equalsIgnoreCase("phone")) {
                            phoneCol = i;
                        }
                    }
                    if (emailCol == -1) {
                        System.out.println("email column not found!");
                        return;
                    }if (phoneCol == -1) {
                        System.out.println("phone column not found!");
                        return;
                    }
                    System.out.println(String.join("\t", col));
                    isHeader = false;
                } else {
                    Matcher matcherEmail = patternEmail.matcher(col[emailCol].trim());
                    Matcher matcherPhone = patternPhone.matcher(col[phoneCol].trim());
                    if ( (!matcherEmail.matches()) || (!matcherPhone.matches())) {
                        System.out.println(String.join("\t", col));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
