package com.china.service.admin;

import com.china.entity.admin.AdminEntity;

public interface AdminService {

    AdminEntity selectOneAdministrator(String user);

    void updatePwd(String id, String pwd);

}
