package kongmenglor.employeespring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        if (employee.getEmail().isEmpty() || employee.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return employeeRepo.save(employee);
    }
    public List<EmployeeEntity> findAll() {
        return this.employeeRepo.findAll();
    }
}
