package mocking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class CSVFIleReaderNonTestable {

    public static void main(String[] args) {
        String filename = args[0];

        List<Employee> employees = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] split = line.split(",");
                employees.add(new Employee(split[1], split[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(employees);
    }
}
