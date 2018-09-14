package mocking;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class CSVProcessorTest {

    private CsvFileReader csvFileReader;

    @Before
    public void setup() {
        csvFileReader = mock(CsvFileReader.class);
    }

    @Test
    public void shouldReturnEMployeeRecords() throws Exception {
        csvFileReader = mock(CsvFileReader.class);
        when(csvFileReader.readLines(anyString())).thenReturn(Arrays.asList("1,Alex","2,Bob"));

        List<Employee> employees = new CSVProcessor(csvFileReader).parse("some file name");

        assertEquals(2, employees.size());
        assertEquals(new Employee("Alex", "1"), employees.get(0));
        assertEquals(new Employee("Bob", "2"), employees.get(1));

        verify(csvFileReader).readLines(anyString());





    }
}