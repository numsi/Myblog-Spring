package com.test.controller;

import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * description:  获得所有用户信息  分页
     *
     * @param  偏移值和每页限制
     * @return java.lang.String
     */
    @GetMapping("/user/list")
    public String getAll(int offset,int limit)
    {

        return restTemplate.getForObject(REST_URL_PREFIX+"/user/list?offset="+offset+"&limit="+limit,String.class);
    }


    /**
     * description:  新增用户
     *
     * @param user   用户对象为参数
     * @return java.lang.String
     */
    @PostMapping("/user/add")
    public String add(User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/add",user,String.class);
    }

    /**
     * description:  用用户ID查找
     *
     * @param id  用户ID
     * @return java.lang.String
     */
    @GetMapping("/user/get/{id}")
    public String queryById(@PathVariable int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id,String.class);
    }

    /**
     * description: 用户登录接口
     *
     * @param user
     * @return java.lang.String
     */
    @PostMapping("/user/login")
    public String queryByItem(User user)
    {

        return restTemplate.postForObject(REST_URL_PREFIX+"/user/login",user,String.class);
    }

    /**
     * description: 更新用户信息 更新密码
     *
     * @param user
     * @return java.lang.String
     */
    @PostMapping("/user/update")
    public String updateUser( User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/update",user,String.class);
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/delete/"+id,String.class);
    }
}
