import org.example.Employee;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.example.Main.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestMain {

    @Test
    public void testReadString() {
        System.out.println("Running Test 1");
        final String fileName = "new_data2.json";
        final String expectid = "Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}\n";
        final String result = readString(fileName);
        assertThat(result, equalTo(expectid));
    }

    @Test
    public void testListToJson() {
        System.out.println("Running Test 2");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", "Smith", "USA", 25));
        final String expectid = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Smith\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"age\": 25\n" +
                "  }\n" +
                "]";
        final String result = listToJson(list);
        assertThat(result, equalTo(expectid));
    }

    @Test
    public void testContainsReadString() {
        System.out.println("Running Test 3");
        final String fileName = "new_data2.json";
        final String expectid = "John";
        final String result = readString(fileName);
        assertThat(result, containsString(expectid));

    }

    @Test
    public void testParseXML() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Running Test 4");
        final String fileName = "data.xml";
        List<Employee> result = parseXML(fileName);
        assertThat(result, hasSize(2));

    }
}
