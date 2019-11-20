package com.signifyd.extract;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Extract {

    private String COMMA_DELIMITER;

    public Extract(String COMMA_DELIMITER) {
        this.COMMA_DELIMITER = COMMA_DELIMITER;
    }

    public List<List<String>> parseCsv (String FILE_NAME) throws FileNotFoundException {

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_NAME));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        return records;

    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(this.COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
