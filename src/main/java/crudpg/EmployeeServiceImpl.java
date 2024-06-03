package crudpg;

import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;

 @Override
 public Employee saveEmployee(Employee employee) {
     return employeeRepository.save(employee);
 }

 @Override
 public Page<Employee> fetchAllEmployees(Pageable pageable) {
     return employeeRepository.findAll(pageable);
 }

 @Override
 public Employee getEmployeeById(Long id) {
     Optional<Employee> employee = employeeRepository.findById(id);
     return employee.orElse(null);
 }

 @Override
 public Employee updateEmployeeById(Long id, Employee employee) {
     Optional<Employee> employee1 = employeeRepository.findById(id);
     if(employee1.isPresent()) {
         Employee originalEmployee = employee1.get();
         if(Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
             originalEmployee.setEmployeeName(employee.getEmployeeName());
         }
         if(Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
             originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
         }
         return employeeRepository.save(originalEmployee);
     }
     return null;
 }

 @Override
 public String deleteDepartmentById(long id) {
     if(employeeRepository.findById(id).isPresent()) {
         employeeRepository.deleteById(id);
         return "Employee Successfully Deleted";
     }
     return "No such employee in database";
 }
}

