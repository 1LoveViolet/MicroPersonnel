package com.group.microPersonnel.controller;
import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.service.AddressService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 127.0.0.1/address/insert ---- post
     * {"name":"hjh1", "alias":"家1","details":"四川省成都市","zipCode":"5551"}
     */
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Address> insertAddress(@RequestBody Address address) {
        return addressService.insertAddress(address);
    }


    /**
     * 127.0.0.1/address/update ---- put
     * {"id":"2","name":"hjh11", "alias":"家11","details":"四川省成都市1","zipCode":"5551"}
     */
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Address> updateAddressById(@RequestBody Address address) {
        return addressService.updateAddressById(address);
    }


    /**
     * 127.0.0.1/address/delete/2 ---- delete
     */
    @DeleteMapping(value = "/delete/{id}")
    public Result<Address> deleteAddressById(@PathVariable int id) {
        return addressService.deleteAddressById(id);
    }

    /**
     * 127.0.0.1/address/get/2 ---- get
     *
     */
    @GetMapping(value = "/get/{id}")
    public Result<Address> getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    /**
     * 127.0.0.1/address/get ---- get
     */
    @GetMapping(value = "/get")
    public List<Address> getAddress() {
        return addressService.getAddress();
    }
    /**
     * 127.0.0.1/address/mocha/ ---- get
     */
    @GetMapping(value = "/mocha/{param1}")
    public List<Address> mochaAddress(@PathVariable String param1){
        return addressService.mochaAddress(param1);
    }

}


