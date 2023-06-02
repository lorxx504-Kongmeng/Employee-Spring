package kongmenglor.employeespring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        List<EmployeeEntity> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee) {
        ResponseEntity<EmployeeEntity> new_employee = employeeService.addEmployee(employee);
        return new_employee;
    }
}
