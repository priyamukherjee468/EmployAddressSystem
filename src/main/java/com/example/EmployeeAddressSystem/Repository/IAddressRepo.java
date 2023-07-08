package com.example.EmployeeAddressSystem.Repository;

import com.example.EmployeeAddressSystem.Model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address,Long> {
}
