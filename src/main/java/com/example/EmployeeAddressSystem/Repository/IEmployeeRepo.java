package com.example.EmployeeAddressSystem.Repository;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee,Long> {

}
