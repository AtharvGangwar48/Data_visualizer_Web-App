
package com.example.datapreprocessor.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CSVUtil {
    public static List<Map<String, String>> parseCSV(InputStream is) {
        List<Map<String, String>> recordsList = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new InputStreamReader(is), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                Map<String, String> row = new HashMap<>();
                record.toMap().forEach(row::put);
                recordsList.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordsList;
    }
}
