import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private List<Employee> listOfEmployees = new ArrayList<>();

    void initList() {
        listOfEmployees.add(new Employee(1, "Tim", "Marketing"));
        listOfEmployees.add(new Employee(2, "Joe", "Sales"));
        listOfEmployees.add(new Employee(3, "Jane", "IT"));
        listOfEmployees.add(new Employee(4, null, null));
    }

    @BeforeEach
    void setup() {
        initList();
        employeeService = new EmployeeService(listOfEmployees);
    }

    @Test
    @Tag("task:1")
    @DisplayName("Retrieve one employee by id")
    void retrieveOneEmployeeById() {
        assertThat(employeeService.getEmployeeById(2))
                .isEqualTo(Optional.of(listOfEmployees.get(1)));
    }

    @Test
    @Tag("task:2")
    @DisplayName("Retrieve other employee by id")
    void retrieveOtherEmployeeById() {
        assertThat(employeeService.getEmployeeById(3))
                .isEqualTo(Optional.of(listOfEmployees.get(2)));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Retrieve employee by id when some fields are null")
    void retrieveEmployeeById_withNullFields() {
        assertThat(employeeService.getEmployeeById(4))
                .isEqualTo(Optional.of(listOfEmployees.get(3)));
    }

    @Test
    @Tag("task:4")
    @DisplayName("Retrieve employee by id when the id does not exist")
    void retrieveEmployeeById_forANonExistingId() {
        assertThat(employeeService.getEmployeeById(7))
                .isEqualTo(Optional.empty());
    }

    @Test
    @Tag("task:5")
    @DisplayName("Retrieve employee details by id")
    void retrieveEmployeeDetailsById() {
        assertThat(employeeService.getEmployeeDetailsById(2))
                .isEqualTo("2 - Joe - Sales");
    }

    @Test
    @Tag("task:6")
    @DisplayName("Retrieve employee details by id when some fields are null")
    void retrieveEmployeeDetailsById_withNullFields() {
        assertThat(employeeService.getEmployeeDetailsById(4))
                .isEqualTo("No employee found for id: 4");
    }

    @Test
    @Tag("task:7")
    @DisplayName("Retrieve employee details by id when the id does not exist")
    void retrieveEmployeeDetailsById_forANonExistingId() {
        assertThat(employeeService.getEmployeeDetailsById(7))
                .isEqualTo("No employee found for id: 7");
    }
}
