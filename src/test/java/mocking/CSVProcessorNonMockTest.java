package mocking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVProcessorNonMockTest {

    private class CVSReaderMock implements CsvFileReader {

        @Override
        public List<String> readLines(String filename) {
            return Arrays.asList("1, Alex", "2, Bob");
        }
    }

    private CsvFileReader fileReader = (filename) -> Arrays.asList("1, Alex", "2, Bob");

    @Test
    public void shouldReturnEMployeeRecords() throws Exception {
        CsvFileReader fileReader = (filename) -> Arrays.asList("1, Alex", "2, Bob");
        List<Employee> employees = new CSVProcessor(fileReader).parse("some file name");

        assertEquals(2, employees.size());
        assertEquals(new Employee("Alex", "1"), employees.get(0));
        assertEquals(new Employee("Bob", "2"), employees.get(1));
    }
}