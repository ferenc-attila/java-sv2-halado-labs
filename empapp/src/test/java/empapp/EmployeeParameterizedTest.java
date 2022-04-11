package empapp;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeParameterizedTest {

    @ParameterizedTest//(name = "Get age, year of birth {0}, age {1}")
//    @ValueSource(ints = {1970, 1980, 1990})
//    @ArgumentsSource(AgeProvider.class)
//    @CsvSource({
//            "1970,30",
//            "1980,20",
//            "1990,10"
//    })
    @CsvFileSource(resources = "/ages.csv", delimiter = ',', useHeadersInDisplayName = true)
    void getAgeTest(int yearOfBirth, int age) {
        Employee employee = new Employee("John Doe", yearOfBirth);
        assertEquals(age, employee.getAge(2000));
//        assertTrue(employee.getAge(2000) >= 0);
    }

    static class AgeProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(1970, 30),
                    Arguments.arguments(1980, 20),
                    Arguments.arguments(2000, 0)
            );
        }
    }
}
