package com.test.controller;

import com.test.entity.Admin;
import com.test.service.AdminService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author numsi
 * @date 2020/4/30 19:37
 */
@RestController
public class AdminProvider {
    /*
    管理员相关接口
     */

    @Autowired
    AdminService adminService;

    /**
     * description: 管理员登录功能
     *
     * @param admin
     * @return com.test.utils.Result
     */
    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody Admin admin)
    {
        List<Admin> admins = adminService.queryAllByItem(admin);
        if(admins==null||admins.size()==0)
        {
            return ResultFactory.buildFailResult("账号密码出错!");
        }
        return ResultFactory.buildSuccessResult(admins.get(0));

    }

    /**
     * description: 更新管理员信息
     *
     * @param admin
     * @return com.test.utils.Result
     */
    @PostMapping("/admin/update")
    public Result adminUpdate(@RequestBody Admin admin)
    {
        Admin res = adminService.update(admin);
        if(res==null)
        {
            return ResultFactory.buildFailResult("更新失败!");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 获取管理员的邮箱地址
     *
     * @param
     * @return com.test.utils.Result
     */
    @GetMapping("/admin/email")
    public Result adminEmail()
    {
        List<Admin> admins = adminService.queryAll();
        return ResultFactory.buildSuccessResult(admins.get(0).getAdminEmail());
    }
}
