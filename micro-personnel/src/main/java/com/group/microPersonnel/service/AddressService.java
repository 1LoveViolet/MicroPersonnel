package com.group.microPersonnel.service;

import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.common.vo.Result;

import java.util.List;

public interface AddressService {
    Result<Address> insertAddress(Address address);
    Result<Address> updateAddressById(Address address);
    Result<Address> deleteAddressById(int id);
    Result<Address> getAddressById(int id);
    List<Address> getAddress();
    List<Address> mochaAddress(String param1);

}
