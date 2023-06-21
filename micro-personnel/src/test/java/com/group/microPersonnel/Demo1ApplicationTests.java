package com.group.microPersonnel;

import com.group.microPersonnel.dao.AddressDao;
import com.group.microPersonnel.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private AddressDao addressDao;
    @Test
    void test1() {
        List<Address> addressList = addressDao.selectList(null);
        System.out.println(addressList);
        Address address = addressDao.selectById(4);
        System.out.println(address);
    }

}