package com.example.EmployeeAddressSystem.Service;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import com.example.EmployeeAddressSystem.Repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;

    public Address saveAddress(Address address) {
        return iAddressRepo.save(address);
    }

    public Address getAddress(Long addId) {
        Optional<Address> optionalAddress= iAddressRepo.findById(addId);
        return optionalAddress.get();
    }

     public Iterable<Address> getAllAddress() {
        return iAddressRepo.findAll();
    }

    public String deleteAddress(long Id) {
        iAddressRepo.deleteById(Id);
        return "deleted";
    }

    public String updateAddressById(long addId, String addName, String city, String state, String zipcode) {
        Optional<Address> AddressOpt = iAddressRepo.findById(addId);
        Address myaddress = null;
        if(AddressOpt.isPresent())
        {
            myaddress = AddressOpt.get();
        }
        else {
            return "Id not Found!!!";
        }
        myaddress.setAddName(addName);
        myaddress.setCity(city);
        myaddress.setState(state);
        myaddress.setZipcode(zipcode);
        iAddressRepo.save(myaddress);
        return "Address updated";

    }
    }

