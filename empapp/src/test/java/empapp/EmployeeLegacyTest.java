package empapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeLegacyTest {

    @Test
    public void getAgeTest() {
        assertEquals(30, new Employee("John Doe", 1970).getAge(2000));
    }
}
