package com.travel.dao;

import org.apache.ibatis.annotations.*;

import com.travel.model.Menu;

import java.util.Date;
import java.util.List;

public interface MenuDAO {
    @Select("SELECT * FROM menus;")
    @Results({
            @Result(column = "mid", property = "mid"),
            @Result(column = "cid", property = "cid"),
            @Result(column = "mname", property = "mname"),
            @Result(column = "mtype", property = "mtype"),
            @Result(column = "beginusedate", property = "beginusedate"),
            @Result(column = "assetcoding", property = "assetcoding"),
            @Result(column = "orivalue", property = "orivalue"),
            @Result(column = "depreciation", property = "depreciation"),
            @Result(column = "netvalue", property = "netvalue"),
            @Result(column = "person", property = "person")
    })
    public List<Menu> getAllMenus();

    @Select("SELECT * FROM menus where mid like #{mid} and cid like #{cid};")
    @Results({
            @Result(column = "mid", property = "mid"),
            @Result(column = "cid", property = "cid"),
            @Result(column = "mname", property = "mname"),
            @Result(column = "mtype", property = "mtype"),
            @Result(column = "beginusedate", property = "beginusedate"),
            @Result(column = "assetcoding", property = "assetcoding"),
            @Result(column = "orivalue", property = "orivalue"),
            @Result(column = "depreciation", property = "depreciation"),
            @Result(column = "netvalue", property = "netvalue"),
            @Result(column = "person", property = "person")
    })
    public List<Menu> getMenuByMidCid(@Param("mid") String mid, @Param("cid") String cid);

    @Insert("insert into menus (cid, mname, mtype, beginusedate, assetcoding, orivalue, depreciation, netvalue, person) values (#{cid}, #{mname}, #{mtype}, #{beginusedate}, #{assetcoding},#{orivalue}, #{depreciation}, #{netvalue},#{person});")
    @Result(javaType = int.class)
    public int addMenu(@Param("cid") int cid, @Param("mname") String mname, @Param("mtype") String mtype, @Param("beginusedate") String beginusedate, @Param("assetcoding") String assetcodin, @Param("orivalue") float orivalue, @Param("depreciation") float depreciation, @Param("netvalue") float netvalue, @Param("person") String person);

    @Update("update menus set mid = #{mid}, cid = #{cid}, mname = #{mname}, mtype = #{mtype}, beginusedate = #{beginusedate}, assetcoding = #{assetcoding},orivalue = #{orivalue}, depreciation = #{depreciation}, netvalue = #{netvalue}, person = #{person} where mid = #{mid};")
    @Result(javaType = int.class)
    public int updateMenuByMid(@Param("mid") int mid, @Param("cid") int cid, @Param("mname") String mname,@Param("mtype") String mtype, @Param("beginusedate") String beginusedate, @Param("assetcoding") String assetcodin, @Param("orivalue") float orivalue, @Param("depreciation") float depreciation, @Param("netvalue") float netvalue, @Param("person") String person);

    @Delete("delete from menus where mid = #{mid};")
    @Result(javaType = int.class)
    public int deleteMenuByMid(@Param("mid") int mid);
}
