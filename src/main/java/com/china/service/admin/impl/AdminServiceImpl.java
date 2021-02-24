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
    public AdminEntity selectOneAdministrator(String user) {
        return adminMapper.selectOne(user);
    }

    @Override
    public void updatePwd(String id, String pwd){
        adminMapper.updatePwd(id, pwd);
    }

}
