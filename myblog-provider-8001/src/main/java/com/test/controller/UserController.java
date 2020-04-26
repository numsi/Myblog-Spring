package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<User> getAll()
    {
        return userService.queryAll();
    }


    /**
     * description: 新增用户
     *
     * @param user  用户对象为参数
     * @return com.test.entity.User 返回新增的用户对象
     */
    @PostMapping("/user/add")
    public User add(@RequestBody  User user)
    {
        return userService.insert(user);
    }

    /**
     * description: 用用户ID查找
     *
     * @param id  用户ID
     * @return com.test.entity.User 用户对象
     */
    @GetMapping("/user/get/{id}")
    public User queryById(@PathVariable("id") int id)
    {
        return userService.queryById(id);
    }

    /**
     * description: 用户登录接口
     *
     * @param username 用户名
     * @param password  密码
     * @return com.test.entity.User 如果存在则返回用户对象 否则返回null
     */
    @GetMapping("/user/login")
    public User queryByItem(String username,String password)
    {
        User user=new User();
        user.setUserUsername(username);
        user.setUserPassword(password);
        List<User> users=userService.queryAllByItem(user);
        try{
            return users.get(0);
        }catch (Exception e)
        {
            return null;
        }

    }

    /**
     * description: 更新用户信息 更新密码
     *
     * @param user 新的用户对象
     * @return com.test.entity.User 更新后的用户对象
     */
    @PostMapping("/user/update")
    public User updateUser(@RequestBody  User user)
    {
        return userService.update(user);
    }

    /**
     * description: 根据用户ID删除用户
     *
     * @param id  用户ID
     * @return boolean 成功删除用户则返回
     */
    @GetMapping("/user/delete/{id}")
    public boolean deleteUser(@PathVariable("id") int id)
    {
        return userService.deleteById(id);
    }
}
