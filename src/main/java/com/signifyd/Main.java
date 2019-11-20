package com.signifyd;

import com.signifyd.domain.Case;
import com.signifyd.domain.CaseTransformed;
import com.signifyd.extract.Extract;
import com.signifyd.load.Load;
import com.signifyd.transform.Transform;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Extract extract = new Extract();
        Transform transform = new Transform();
        Load load = new Load();
        List<Case> data = extract.getCsv("/Users/niallmorgan/Code/signifyd/etl-assessment/src/main/resources/trans-2018-q1.csv");
        List<CaseTransformed> transData = new ArrayList<>();

        data.forEach(d -> {

            try {
                CaseTransformed transformed = transform.scrubData(d);
                transData.add(transformed);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });


        try {
            load.writeCsv(transData,"/Users/niallmorgan/Code/signifyd/etl-assessment/src/main/resources/out.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
