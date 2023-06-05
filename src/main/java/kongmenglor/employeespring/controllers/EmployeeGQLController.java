package kongmenglor.employeespring.controllers;
import kongmenglor.employeespring.entities.EmployeeEntity;
import kongmenglor.employeespring.services.EmployeeService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/gqlapi/employees")
public class EmployeeGQLController {
    EmployeeService employeeService;

    public EmployeeGQLController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @QueryMapping
    public List<EmployeeEntity> findAllEmployees() {
        return this.employeeService.findAll();
    }


}
