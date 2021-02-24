package com.china.mapper.admin;

import com.china.entity.admin.AdminEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where user = #{user}")
    @Results(value = {
            @Result(column = "part_id", property = "partId"),
            @Result(column = "role_id", property = "roleId"),
            @Result(column = "crt_date", property = "crtDate")
    })
    AdminEntity selectOne(@Param("user") String user);

    @Update("<script> update admin  <set><if test='pwd!=null'> pwd = #{pwd} </if></set> where id = #{id} </script>")
    void updatePwd(String id, String pwd);

}
