package com.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.entity.Admin;
import com.test.entity.User;
import com.test.util.TokenUtil;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author numsi
 * @date 2020/5/1 21:57
 */
@RestController
public class AdminController {
    /*
    管理员相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8003";

    /**
     * description: 更新管理员信息
     *
     * @param admin
     * @return com.test.utils.Result
     */
    @PostMapping("/admin/update")
    public Result adminUpdate(@RequestBody Admin admin)
    {return restTemplate.postForObject(REST_URL_PREFIX+"/admin/update",admin,Result.class);
    }

    /**
     * description: 管理员登录功能
     *
     * @param admin
     * @return com.test.utils.Result
     */
    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody Admin admin)
    {
        Result result = restTemplate.postForObject(REST_URL_PREFIX+"/admin/login",admin,Result.class);
        if(result.getCode() == 200){
            Admin temp = JSONObject.parseObject(JSONArray.toJSONString(result.getResult()), Admin.class);
//            User temp = (User)result.getResult();
            User user = new User();
            user.setUserId(-1);
            user.setUserUsername("admin");
            String token = TokenUtil.sign(user);
            HashMap<String,Object> hs=new HashMap<>();
            hs.put("token",token);
            hs.put("user",user);
            return ResultFactory.buildSuccessResult(hs);
        }else{
            return result;
        }
    }

    /**
     * description: 获取管理员的邮箱信息
     *
     * @param
     * @return com.test.utils.Result
     */
    @GetMapping("/admin/email")
    public Result adminEmail()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/admin/email",Result.class);
    }

}
