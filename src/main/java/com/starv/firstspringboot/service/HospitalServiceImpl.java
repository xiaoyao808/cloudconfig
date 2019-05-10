package com.starv.firstspringboot.service;

import com.starv.firstspringboot.bean.Medicine;
import com.starv.firstspringboot.bean.User;
import com.starv.firstspringboot.mapper.HospitalMapper;
import com.starv.firstspringboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: firstspringboot
 * @Package: com.starv.firstspringboot.service
 * @ClassName: HospitalServiceImpl
 * @Author: root
 * @Description: ${description}
 * @Date: 2019/5/7 10:41
 * @Version: 1.0
 */
@Service
public class HospitalServiceImpl implements  HospitalService{

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public User verifyUname(String uname) {
        return hospitalMapper.verifyUname(uname);
    }

    @Override
    public User login(String uname, String password) {
        return hospitalMapper.login(uname,password);
    }

    @Override
    public List<Medicine> getMedList(PageUtils pageUtils) {
        return hospitalMapper.getMedList(pageUtils);
    }

    @Override
    public Integer getMedCount(String mohu) {
        return hospitalMapper.getMedCount(mohu);
    }

    @Override
    public List<Medicine> getAllType() {
        return hospitalMapper.getAllType();
    }

    @Override
    public void addMedMethod(Medicine medicine) {
        hospitalMapper.addMedMethod(medicine);
    }

    @Override
    public Medicine stockMed(Integer yid) {
        return hospitalMapper.stockMed(yid);
    }

    @Override
    public void updateMed(Medicine medicine) {
        hospitalMapper.updateMed(medicine);
    }


}
