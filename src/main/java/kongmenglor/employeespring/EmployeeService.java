package kongmenglor.employeespring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepo.save(employee);
    }
    public List<EmployeeEntity> findAll() {
        return this.employeeRepo.findAll();
    }
}
