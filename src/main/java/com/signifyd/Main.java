package com.signifyd;

import com.signifyd.extract.Extract;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Extract extract = new Extract("\\t");
        List<List<String>> data = new ArrayList<>();

        try {
            data = extract.parseCsv("/Users/niallmorgan/Code/signifyd/etl-assessment/src/main/resources/trans-2018-q1.csv");
            for (List<String> line : data) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found " +  e.getMessage());
        }


    }


}
