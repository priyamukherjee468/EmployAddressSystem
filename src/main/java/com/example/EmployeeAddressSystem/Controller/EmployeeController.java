package com.example.EmployeeAddressSystem.Controller;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import com.example.EmployeeAddressSystem.Service.AddressService;
import com.example.EmployeeAddressSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("getEmployee/{empId}")
    public Employee getEmployee(@PathVariable Long empId){
        return employeeService.getEmployee(empId);
    }
    @GetMapping("getEmployees")
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("deleteEmployee/{empId}")

    public String deleteEmployee(@PathVariable Long empId) {
        return employeeService.deleteEmployee(empId);
    }
    @PutMapping("updateEmployee/{empId}/{empName}")
    public String updateEmployeeById(@PathVariable Long empId,@PathVariable String empName) {
        return employeeService.updateEmployeeById(empId,empName);
    }

}
