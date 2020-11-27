package com.china.mapper.admin;

import com.china.entity.admin.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface AdminMapper {

    @Select("select * from admin.admin where user = #{user}")
    AdminEntity selectOne(@Param("user") String user);

//    @Update("<script> update tbl_bal_t  <set><if test='TOTAL_AMT!=null'> total_amt = #{TOTAL_AMT}, </if><if test='COMM_AMT!=null'> comm_amt = #{COMM_AMT}, </if><if test='FRZ_AMT!=null'> frz_amt = #{FRZ_AMT} </if></set> where cd_bin = #{cdBin} </script>")
//    void updateBal(Map param);

}
