package crudpg;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
   Employee saveEmployee(Employee employee);
   Page<Employee> fetchAllEmployees(Pageable pageable);
   Employee getEmployeeById(Long id);
   Employee updateEmployeeById(Long id, Employee employee);
   String deleteDepartmentById(long id);
}
