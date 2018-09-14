package mocking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

interface CsvFileReader {
    List<String> readLines(String filename);
}

class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> readLines(String filename) {
        List<String> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return list;
    }
}

public class CSVProcessor {

    private CsvFileReader csvFileReader;

    CSVProcessor(CsvFileReader csvFileReader) {
        this.csvFileReader = csvFileReader;
    }

    public List<Employee> parse(String filename) {
        return csvFileReader.readLines(filename)
                .stream()
                .map(line -> {
                    String[] split = line.split(",");
                    return new Employee(split[1], split[0]);
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = new CSVProcessor(new CsvFileReaderImpl()).parse("ny.file.name");
        System.out.println(employees);
    }
}


