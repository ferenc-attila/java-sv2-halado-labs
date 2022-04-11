package empapp;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static empapp.EmployeeAssert.assertThat;

public class EmployeeServiceAssertJExtensionTest {

    @Test
    void listEmployeesTest() {
        List<Employee> employees = new EmployeeService().listEmployees();

        Employee employee = employees.get(0);

        Condition<Employee> familyNameIsDoe =
                new Condition<>(e -> e.getName().endsWith("Doe"), "Family name is Doe");
        assertThat(employee).hasName("John Doe");
    }
}
