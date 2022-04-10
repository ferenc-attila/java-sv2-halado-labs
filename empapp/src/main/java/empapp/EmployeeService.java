package empapp;

import java.util.List;

public class EmployeeService {

    public List<Employee> listEmployees() {
        return List.of(new Employee("John Doe", 1970),
                new Employee("Jack Doe", 1980));
    }

    public List<String> listEmployeeNames() {
        return List.of("John Doe", "Jack Doe");
    }
}