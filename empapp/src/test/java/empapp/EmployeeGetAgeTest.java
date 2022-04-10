package empapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EntityTest
public class EmployeeGetAgeTest {

    Employee employee;

    @Nested
    class WithYearOfBirth1980Test {

        @BeforeEach
        void init() {
            System.out.println("Init with 1980");
            employee = new Employee("John Doe", 1980);
        }

        @Test
        void getAgeTest() {
            assertEquals(30, employee.getAge(2010));
        }
    }

    @Nested
    class WithYearOfBirth1990Test {

        @BeforeEach
        void init() {
            System.out.println("Init with 1990");
            employee = new Employee("John Doe", 1990);
        }

        @Test
        void getAgeTest() {
            assertEquals(30, employee.getAge(2020));
        }
    }
}
