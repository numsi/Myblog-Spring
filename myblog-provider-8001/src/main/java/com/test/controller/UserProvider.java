package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.User;
import com.test.service.UserService;
import com.test.utils.ListUtis;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
public class UserProvider {
    @Autowired
    UserService userService;

    /**
     * description: 获取所有的用户信息
     * 
     * @param  
     * @return java.util.List<com.test.entity.User>  用户列表
     */
    @GetMapping("/user/list")
    public Result getAll(@PathParam("pageNum") int pageNum,@PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users=userService.queryAll();
//        if(users==null||users.size()==0)
//        {
//            return ResultFactory.buildFailResult("暂无数据");
//        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return ResultFactory.buildSuccessResult(pageInfo);
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

        if(ListUtis.isNotNullEmpty(users))
        {
            return ResultFactory.buildFailResult("用户名已存在，请修改");
        }
        user.setUerAbled(0);
        user.setUserGender(0);
        user.setUserCreattime(new Date());
        user.setUserImgUrl("https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png");
        User res=userService.insert(user);
        if(res!=null)
        {
            return ResultFactory.buildSuccessResult(res);
        }
        return ResultFactory.buildFailResult("新增用户失败");

//        if(users==null||users.size()==0)
//        {
//            User res=userService.insert(user);
//            if(res!=null)
//            {
//                return ResultFactory.buildSuccessResult(res);
//            }
//            return ResultFactory.buildFailResult("新增用户失败");
//        }
//        return ResultFactory.buildFailResult("已存在同名用户，请修改用户名");
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
        if(ListUtis.isNotNullEmpty(users))
        {
            User res = users.get(0);
            if(res.getUerAbled()==1)
            {
                return ResultFactory.buildFailResult("登录失败,账号已被封禁");
            }
            return ResultFactory.buildSuccessResult(res);
        }
        return ResultFactory.buildFailResult("账号或密码错误，登录失败");
//        if(users==null||users.size()==0)
//        {
//            return ResultFactory.buildFailResult("账号或密码错误，登录失败");
//        }
//        if(users.get(1).getUerAbled()==1)
//        {
//            return ResultFactory.buildFailResult("登录失败,账号已被封禁");
//        }
//        return ResultFactory.buildSuccessResult(users.get(1));

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
