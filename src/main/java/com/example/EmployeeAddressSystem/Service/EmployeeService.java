package com.example.EmployeeAddressSystem.Service;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import com.example.EmployeeAddressSystem.Repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public Employee saveEmployee(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    public Employee getEmployee(Long empId) {
        Optional<Employee> optionalEmployee= iEmployeeRepo.findById(empId);
        return optionalEmployee.get();
    }

    public Iterable<Employee> getAllEmployees() {
        return iEmployeeRepo.findAll();
    }



    public String deleteEmployee(Long empId) {
         iEmployeeRepo.deleteById(empId);
         return "deleted";
    }

    public String updateEmployeeById(Long empId, String empName) {
        Optional<Employee> EmployeeOpt = iEmployeeRepo.findById(empId);

        if(EmployeeOpt.isPresent())
        {
            Employee employee=EmployeeOpt.get();
           employee.setEmpName(empName);
            iEmployeeRepo.save(employee);
            return "employee update successfully.";
        }
        else {
            return "Id not Found!!!";
        }


    }


}

