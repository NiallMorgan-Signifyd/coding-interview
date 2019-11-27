package com.signifyd.extract;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.signifyd.domain.Case;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Extract {


    public List<Case> getCsv(String CSV_FILE_PATH){

        List<Case> cases = new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {
            CsvToBean<Case> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Case.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            cases = csvToBean.parse();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return cases;
    }


}

