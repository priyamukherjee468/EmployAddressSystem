package com.example.EmployeeAddressSystem.Controller;

import com.example.EmployeeAddressSystem.Model.Address;
import com.example.EmployeeAddressSystem.Model.Employee;
import com.example.EmployeeAddressSystem.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("saveAddress")
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
    @GetMapping("getAddress/{addId}")
    public Address getAddress(@PathVariable Long addId){
        return addressService.getAddress(addId);
    }
    @GetMapping("getAddress")
    public Iterable<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @DeleteMapping("Address/{Id}")

    public String deleteAddress(@PathVariable long Id) {
        return addressService.deleteAddress(Id);
    }
    @PutMapping("address/{addId}/{city}/{state}/{zipcode}")
    public String updateAddressById(@PathVariable long addId,@PathVariable String addName,@PathVariable String city,@PathVariable String state,@PathVariable String zipcode) {
        return addressService.updateAddressById(addId,addName,city,state,zipcode);
    }
}
