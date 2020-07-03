package com.atguigu.springboot04restfulweb.controller;

import com.atguigu.springboot04restfulweb.dao.EmployeeDao;
import com.atguigu.springboot04restfulweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author hlq
 * @create 2020-07-02 22:54
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @GetMapping("/emps")
    //查询所有员工返回列表页面
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认会拼串
        return "emp/list";
    }
}
