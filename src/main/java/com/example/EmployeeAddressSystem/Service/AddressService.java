package com.example.EmployeeAddressSystem.Service;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import com.example.EmployeeAddressSystem.Repository.IAddressRepo;
import jakarta.transaction.Transactional;
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

    public String deleteAddress(Long Id) {
        iAddressRepo.deleteById(Id);
        return "deleted";
    }

    @Transactional
    public String updateAddressById(long addId, String city, String state, String zipcode) {
        Optional<Address> AddressOpt = iAddressRepo.findById(addId);

        if(AddressOpt.isPresent())
        {
            Address address=AddressOpt.get();
            address.setCity(city);
            address.setState(state);
            address.setZipcode(zipcode);
            iAddressRepo.save(address);
            return "Address updated";
        }
        else {
            return "Id not Found!!!";
        }



    }
    }

