package crudpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;

   @PostMapping("/employee")
   public Employee saveEmployee(@RequestBody Employee employee) {
       return employeeService.saveEmployee(employee);
   }

   @GetMapping("/employee")
   public Page<Employee> getAllEmployees(@PageableDefault(sort = "employeeName", direction = Sort.Direction.ASC) Pageable pageable) {
       return employeeService.fetchAllEmployees(pageable);
   }

   @GetMapping("/employee/{id}")
   public Employee getEmployeeById(@PathVariable("id") Long id) {
       return employeeService.getEmployeeById(id);
   }

   @PutMapping("/employee/{id}")
   public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
       return employeeService.updateEmployeeById(id, employee);
   }

   @DeleteMapping("/employee/{id}")
   public String deleteEmployee(@PathVariable("id") Long id) {
       return employeeService.deleteDepartmentById(id);
   }
}
