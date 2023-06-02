package kongmenglor.employeespring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public ResponseEntity<EmployeeEntity> addEmployee(EmployeeEntity employee) {
        if (employee.getName().isEmpty() && employee.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Require Name/Email from Client (CODE 400) \n");
        }
        return ResponseEntity<this.employeeRepo.save(employee)>();
    }
    public List<EmployeeEntity> findAll() {
        return this.employeeRepo.findAll();
    }
}
