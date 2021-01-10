package com.china.mapper.admin;

import com.china.entity.admin.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("<script> " +
            "select" +
            " menu_id," +
            " menu_name," +
            " menu_level," +
            " menu_parent," +
            " menu_type," +
            " menu_url " +
            "from menus where" +
            " state = 1 " +
            "<if test='level>0'>" +
            " and menu_level = #{level}" +
            "</if>" +
            "<if test='parent!=null'>" +
            " and menu_parent = #{parent}" +
            "</if>" +
            "<if test='type>0'>" +
            " and menu_type = #{type}" +
            "</if>" +
            " order by menu_seq asc" +
            "</script>")
    List<MenuEntity> selectList(@Param("level") int level, @Param("parent") String parent, @Param("type") int type);

    @Select("select" +
            " menu_id," +
            " menu_name," +
            " menu_level," +
            " menu_parent," +
            " menu_type," +
            " menu_url " +
            "from menus where" +
            " menu_id = 1 ")
    MenuEntity selectOne();


}
