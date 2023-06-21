package com.group.microPersonnel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.microPersonnel.dao.UserDao;
import com.group.microPersonnel.domain.User;
import com.group.microPersonnel.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
