package kongmenglor.employeespring.controllers;


import kongmenglor.employeespring.dtos.UpdateEmployeeDTO;
import kongmenglor.employeespring.entities.EmployeeEntity;
import kongmenglor.employeespring.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        List<EmployeeEntity> employees = this.employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity new_Employee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(new_Employee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody UpdateEmployeeDTO employeeDTO) {
        EmployeeEntity update_Employee = this.employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(update_Employee,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam Long id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.employeeService.findById(id), HttpStatus.OK);
    }
}
