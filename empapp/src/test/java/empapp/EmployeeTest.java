package empapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    void getAgeTest() {
        assertEquals(30, new Employee("John Doe", 1970).getAge(2000));
    }
}
