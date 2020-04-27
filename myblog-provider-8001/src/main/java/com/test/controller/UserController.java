package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     * description: 获取所有的用户信息
     * 
     * @param  
     * @return java.util.List<com.test.entity.User>  用户列表
     */
    @GetMapping("/user/list")
    public Result getAll(@PathParam("offset") int offset,@PathParam("limit") int limit)
    {

        List<User> users=userService.queryAllByLimit(offset,limit);
        if(users==null||users.size()==0)
        {
            return ResultFactory.buildFailResult("暂无数据");
        }
        return ResultFactory.buildSuccessResult(users);
    }


    /**
     * description: 新增用户
     *
     * @param user  用户对象为参数
     * @return com.test.entity.User 返回新增的用户对象
     */
    @PostMapping("/user/add")
    public Result add(@RequestBody  User user)
    {
        User temp=new User();
        temp.setUserUsername(user.getUserUsername());
        List<User> users=userService.queryAllByItem(temp);
        if(users==null||users.size()==0)
        {
            User res=userService.insert(user);
            if(res!=null)
            {
                return ResultFactory.buildSuccessResult(res);
            }
            return ResultFactory.buildFailResult("新增用户失败");
        }
        return ResultFactory.buildFailResult("已存在同名用户，请修改用户名");
    }

    /**
     * description: 用用户ID查找
     *
     * @param id  用户ID
     * @return com.test.entity.User 用户对象
     */
    @GetMapping("/user/get/{id}")
    public Result queryById(@PathVariable("id") int id)
    {
        User res=userService.queryById(id);

        if(res!=null)
        {
            return ResultFactory.buildSuccessResult(res);
        }
        return ResultFactory.buildFailResult("找不到该用户");
    }

    /**
     * description: 用户登录接口
     *
     * @param username 用户名
     * @param password  密码
     * @return com.test.entity.User 如果存在则返回用户对象 否则返回null
     */
    @PostMapping("/user/login")
    public Result queryByItem(@RequestBody User user)
    {


        List<User> users=userService.queryAllByItem(user);
        if(users==null||users.size()==0)
        {
            return ResultFactory.buildFailResult("账号或密码错误，登录失败");
        }
        return ResultFactory.buildSuccessResult(users.get(0));

    }

    /**
     * description: 更新用户信息 更新密码
     *
     * @param user 新的用户对象
     * @return com.test.entity.User 更新后的用户对象
     */
    @PostMapping("/user/update")
    public Result updateUser(@RequestBody  User user)
    {
        return ResultFactory.buildSuccessResult(userService.update(user));
    }

    /**
     * description: 根据用户ID删除用户
     *
     * @param id  用户ID
     * @return boolean 成功删除用户则返回
     */
    @GetMapping("/user/delete/{id}")
    public Result deleteUser(@PathVariable("id") int id)
    {
        if(userService.deleteById(id))
        {
            return ResultFactory.buildSuccessResult(null);
        }
        return ResultFactory.buildFailResult("删除用户失败");
    }
}
