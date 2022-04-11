package empapp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static empapp.EmployeeWithNameMatcher.employeeWithName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceWithHamcrestTest {

    @Test
    void listEmployeesTest() {
        List<Employee> employees = new EmployeeService().listEmployees();

        assertThat(employees, contains(
                hasProperty("name", equalTo("John Doe")),
                hasProperty("yearOfBirth", equalTo(1980))
        ));
    }

    @Test
    void listEmployeeWithSelfCreatedMatcherTest() {
        List<Employee> employees = new EmployeeService().listEmployees();

        assertThat(employees, hasItem(
                employeeWithName(equalTo("John Doe"))
        ));

        assertThat(employees.get(0), employeeWithName(startsWith("Joh")));
    }
}
