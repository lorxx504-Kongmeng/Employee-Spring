package kongmenglor.employeespring.services;
import kongmenglor.employeespring.dtos.UpdateEmployeeDTO;
import kongmenglor.employeespring.entities.EmployeeEntity;
import kongmenglor.employeespring.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        if (employee.getEmail().isEmpty() || employee.getName().isEmpty() || employee.getPassword().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return employeeRepo.save(employee);
    }
    public List<EmployeeEntity> findAll() {
        return this.employeeRepo.findAll();
    }

    public EmployeeEntity updateEmployee(UpdateEmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> employee_Opt = this.employeeRepo.findEmployeeById(employeeDTO.id);
        if (employee_Opt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        EmployeeEntity employee = employee_Opt.get();
        if (!employeeDTO.email.isEmpty()) {
            employee.setEmail(employeeDTO.email);
        }
        if (!employeeDTO.password.isEmpty()) {
            employee.setPassword(employeeDTO.jobTitle);
        }
        if (!employeeDTO.jobTitle.isEmpty()) {
            employee.setJobTitle(employeeDTO.jobTitle);
        }
        if (employeeDTO.phone != employee.getPhone()) {
            employee.setPhone(employeeDTO.phone);
        }
        if (!employeeDTO.imageUrl.isEmpty()) {
            employee.setImageUrl(employeeDTO.imageUrl);
        }
        return this.employeeRepo.save(employee);
    }
    public EmployeeEntity findById(Long id) {
        return this.employeeRepo.findEmployeeById(id).get();
    }
    public void deleteEmployee(Long id) {
        this.employeeRepo.deleteEmployeeById(id);
    }
}
