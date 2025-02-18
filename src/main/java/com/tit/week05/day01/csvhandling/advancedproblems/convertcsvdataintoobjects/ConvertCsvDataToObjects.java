package com.tit.week05.day01.csvhandling.advancedproblems.convertcsvdataintoobjects;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ConvertCsvDataToObjects {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\StudentData.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Student> students = csvToBean.parse();

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
