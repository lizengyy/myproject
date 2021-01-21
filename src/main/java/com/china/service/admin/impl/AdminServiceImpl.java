package com.china.service.admin.impl;

import com.china.entity.admin.AdminEntity;
import com.china.mapper.admin.AdminMapper;
import com.china.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminEntity selectOneAdministrator(String key) {
        return adminMapper.selectOne(key);
    }

}
