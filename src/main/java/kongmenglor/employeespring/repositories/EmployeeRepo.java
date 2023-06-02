package kongmenglor.employeespring.repositories;

import kongmenglor.employeespring.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {
    Optional<EmployeeEntity> findEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
