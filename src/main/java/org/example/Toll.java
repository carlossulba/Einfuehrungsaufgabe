package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Toll {
    public String path;
    public BufferedReader reader;
    public CSVParser records;

    public Toll() {
    }

    public void setPath(String path) {
        this.path = "C:\\Users\\carlo\\OneDrive\\Escritorio\\Work\\JunITer\\Einfuehrungsaufgabe\\" + path;
    }
    public void setReader(String path) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(path));
    }
    public void setRecords() throws IOException {
        this.records = CSVParser.parse(this.reader, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
    }
}
