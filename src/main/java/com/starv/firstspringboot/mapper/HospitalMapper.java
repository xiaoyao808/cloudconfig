package com.starv.firstspringboot.mapper;

import com.starv.firstspringboot.bean.Medicine;
import com.starv.firstspringboot.bean.User;
import com.starv.firstspringboot.utils.PageUtils;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ProjectName: firstspringboot
 * @Package: com.starv.firstspringboot.mapper
 * @ClassName: HospitalMapper
 * @Author: root
 * @Description: ${description}
 * @Date: 2019/5/7 10:43
 * @Version: 1.0
 */
@Mapper
public interface HospitalMapper {

    @Select("select *  from t_user where uname=#{uname}")
    User verifyUname(@Param("uname") String uname);

    @Select("select * from t_user where uname=#{uname} and password =#{password} ")
    User login(@Param("uname") String uname, @Param("password") String password);

    @Select("select count(*) from t_yao where projectNumber like concat('%',#{mohu},'%')")
    Integer getMedCount(@Param("mohu") String mohu);

    @Select("select * from t_yao where projectNumber like concat('%',#{mohu},'%') limit #{startIndex},#{pageSize}")
    List<Medicine> getMedList(PageUtils pageUtils);

    @Select("SELECT distinct medType FROM t_yao ")
    List<Medicine> getAllType();

    @Insert("insert into t_yao(projectNumber,projectName,price,proCount,costPrice,medType) values(#{projectNumber},#{projectName},#{price},#{proCount},#{costPrice},#{medType})")
    void addMedMethod(Medicine medicine);

    @Select("select * from t_yao where yid = #{yid}")
    Medicine stockMed(Integer yid);

    @Update("update t_yao set projectNumber=#{projectNumber},projectName=#{projectName},price=#{price},proCount=#{proCount},costPrice=#{costPrice},medType=#{medType} where yid = #{yid}")
    void updateMed(Medicine medicine);
}
