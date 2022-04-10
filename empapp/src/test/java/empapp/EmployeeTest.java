package empapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@EntityTest
class EmployeeTest implements PrintNameCapable {

    Employee employee;

    public EmployeeTest() {
        System.out.println("CONSTRUCTOR");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @BeforeEach
    void initEmployee() {
        System.out.println("INIT");
        employee = new Employee("John Doe", 1970);
    }

    @Test
//    @Disabled("Until issue 125 not fixed.")
    @DisplayName("Test age calculation with positive number!")
    void getAgeTest() {
        System.out.println("TC1");
        assertEquals(30, employee.getAge(2000));

//        assertTrue(30 == employee.getAge(2000));

        assertNotNull(employee);

        Employee expected = new Employee("John Doe", 1970);
        assertEquals(expected, employee);
        assertNotSame(expected, employee);

        assertEquals(1.0, 1.0, 0.005);

        assertAll(
                () -> assertEquals("John Doe", employee.getName()),
                () -> assertEquals(30, employee.getAge(2000))
        );
//        fail();
    }

    @Test
//    @DisabledOnOs(OS.WINDOWS)
    void get_Age_With_Zero_Test() {
        System.out.println("TC2");
        assertEquals(0, employee.getAge(1970));
    }

    @Test
    void createWithTooEarlyYearOfBirthTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Employee("John Doe", 1700));

        assertEquals("Year: 1700 too early!", iae.getMessage());
    }
}
