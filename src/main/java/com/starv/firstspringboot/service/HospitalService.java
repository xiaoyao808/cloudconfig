package com.starv.firstspringboot.service;

import com.starv.firstspringboot.bean.Medicine;
import com.starv.firstspringboot.bean.User;
import com.starv.firstspringboot.utils.PageUtils;

import java.util.List;

/**
 * @ProjectName: firstspringboot
 * @Package: com.starv.firstspringboot.service
 * @ClassName: HospitalService
 * @Author: root
 * @Description: ${description}
 * @Date: 2019/5/7 10:40
 * @Version: 1.0
 */
public interface HospitalService {

    User verifyUname(String uname);

    User login(String uname, String password);

    List<Medicine> getMedList(PageUtils pageUtils);

    Integer getMedCount(String mohu);

    List<Medicine> getAllType();

    void addMedMethod(Medicine medicine);

    Medicine stockMed(Integer yid);

    void updateMed(Medicine medicine);
}
