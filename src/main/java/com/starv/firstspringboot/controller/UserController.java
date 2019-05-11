package com.starv.firstspringboot.controller;
import com.starv.firstspringboot.bean.Medicine;
import com.starv.firstspringboot.bean.Result;
import com.starv.firstspringboot.bean.User;
import com.starv.firstspringboot.service.HospitalService;
import com.starv.firstspringboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @ProjectName: firstspringboot
 * @Package: com.starv.controller
 * @ClassName: UserController
 * @Author: root
 * @Description: ${description}
 * @Date: 2019/5/7 9:47
 * @Version: 1.0
 */
@Controller
public class UserController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("index")
    public String hello(){
        return "index";
    }
    
     @RequestMapping("index")
    public String hello(){
        return "index";
    }


    @RequestMapping("saypaipai")
    public String saypaipai(){
        return "index";
    }

    @RequestMapping("verifyUname")
    @ResponseBody
    public Result verifyUname(String uname) {
        User user = hospitalService.verifyUname(uname);
        if (user!=null) {
            return new Result("成功",true);
        }else {
            return new Result("失败",false);
        }
    }
    @RequestMapping("login")
    @ResponseBody
    public Result login(String uname, String password, Integer remenber, HttpServletRequest request, HttpSession session) {
        User user = hospitalService.login(uname,password);
     /*   if (remenber==1){
            Cookie cookie = new Cookie("uname",uname);
            Cookie password1 = new Cookie("password", password);
            Cookie remenber1 = new Cookie("remenber","true");
            //设置过期时间
            cookie.setMaxAge(60*60);
            password1.setMaxAge(60*60);
            remenber1.setMaxAge(60*60);
            response.addCookie(cookie);
            response.addCookie(remenber1);
            response.addCookie(password1);
        }*/
        if (user!=null) {
            session.setAttribute("user",user);
            return new Result("成功",true);
        }else {
            return new Result("失败",false);
        }
    }

    @RequestMapping("getMedList")
    public String getAllList(HttpServletRequest request,String mohu,Integer cpage){
        if (mohu==null){
            mohu="";
        }
        Integer count =   hospitalService.getMedCount(mohu);
        PageUtils pageUtils = new PageUtils(cpage, count, mohu, "/getMedList");
        List<Medicine> MedicineList = hospitalService.getMedList(pageUtils);
        request.setAttribute("MedicineList", MedicineList);
        request.setAttribute("pu",pageUtils);
        return "list";
    }

    @RequestMapping("addMedMethod")
    public String addMedMethod(Medicine medicine) {
        hospitalService.addMedMethod(medicine);
        return "redirect:getMedList";
    }
    @RequestMapping("getAllType")
    @ResponseBody
    public List<Medicine> getAllType() {
        List<Medicine> getAllType =  hospitalService.getAllType();
        return getAllType;
    }
    @RequestMapping("stockMed")
    public String stockMed(Integer yid,HttpServletRequest request) {
        Medicine medicine = hospitalService.stockMed(yid);
        request.setAttribute("medicine", medicine);
        return "update";
    }
    @RequestMapping("updateMed")
    public String updateMed(Medicine medicine){
        hospitalService.updateMed(medicine);
        return "redirect:getMedList";
    }
}
