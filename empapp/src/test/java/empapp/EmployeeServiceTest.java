package empapp;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class EmployeeServiceTest {

    @Test
    void listEmployeeNamesTest() {
        assertEquals(List.of("John Doe", "Jack Doe"), new EmployeeService().listEmployeeNames());
    }

    @Test
    void listEmployeesTest() {
//        assertEquals(List.of(new Employee("John Doe", 1970),
//                new Employee("Jack Doe", 1980)), new EmployeeService().listEmployees());

        EmployeeService employeeService = null;

        assumeTrue(employeeService != null);

        assertEquals(List.of("John Doe", "Jack Doe"), new EmployeeService().listEmployees().stream()
                .map(Employee::getName).collect(Collectors.toList()), "Employee lists are different");
    }

}