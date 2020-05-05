package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.entity.User;
import com.test.util.TokenUtil;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
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
     * @param  页码及每页的限制
     * @return java.lang.String
     */
    @GetMapping("/user/list")
    public Result getAll(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {

        return restTemplate.getForObject(REST_URL_PREFIX+"/user/list?pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }


    /**
     * description:  新增用户
     *
     * @param user   用户对象为参数
     * @return java.lang.String
     */
    @PostMapping("/user/add")
    public Result add(@RequestBody User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/add",user,Result.class);
    }

    /**
     * description:  用用户ID查找
     *
     * @param id  用户ID
     * @return java.lang.String
     */
    @GetMapping("/user/get/{id}")
    public Result queryById(@PathVariable int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id,Result.class);
    }

    /**
     * description: 用户登录接口
     *
     * @param user
     * @return java.lang.String
     */
    @PostMapping("/user/login")
    public Result queryByItem(@RequestBody User user)
    {
        Result result = restTemplate.postForObject(REST_URL_PREFIX+"/user/login",user,Result.class);
        if(result.getCode() == 200){
            User users = JSONObject.parseObject(JSONArray.toJSONString(result.getResult()), User.class);
//            User temp = (User)result.getResult();
            String token = TokenUtil.sign(users);
            HashMap<String,Object> hs=new HashMap<>();
            hs.put("token",token);
            hs.put("user",users);
            return ResultFactory.buildSuccessResult(hs);
        }else{
            return result;
        }
    }

    /**
     * description: 更新用户信息 更新密码
     *
     * @param user
     * @return java.lang.String
     */
    @PostMapping("/user/update")
    public Result updateUser(@RequestBody User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/update",user,Result.class);
    }

    /**
     * description: 删除某一用户信息
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/user/delete/{id}")
    public Result deleteUser(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/delete/"+id,Result.class);
    }

    @GetMapping("/user/change/{id}")
    public Result changeUser(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/change/"+id,Result.class);
    }
}
