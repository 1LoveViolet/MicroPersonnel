package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.dao.AddressDao;
import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.service.AddressService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public Result<Address> insertAddress(Address address) {
        // 初始化 user 某些属性
        address.setUpdateTime(LocalDateTime.now());
        address.setCreateDate(LocalDateTime.now());
        // 插入 certificate
        addressDao.insert(address);
        // 返回结果
        return Result.ok();
    }

    @Override
    public Result<Address> updateAddressById(Address address) {
        address.setUpdateTime(LocalDateTime.now());
        addressDao.updateById(address);
        return Result.ok();
    }


    @Override
    public Result<Address> deleteAddressById(int id) {
        addressDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<Address> getAddressById(int id) {
        return Result.ok(addressDao.selectById(id));
    }

    @Override
    public List<Address> getAddress() {
        return addressDao.selectList(null);
    }
    @Override
    public List<Address> mochaAddress(String param1) {
        return addressDao.mochaAddress(param1);
    }
}
