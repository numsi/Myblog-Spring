package com.test.controller;

import com.test.entity.Follow;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/4/28 20:09
 */
@RestController
public class FollowController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * description: 获取用户所有关注信息
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return java.lang.String
     */
    @GetMapping("/follow/get")
    public Result getAll(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {

        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/get?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }


    /**
     * description: 改变关注状态
     *
     * @param user
     * @param followed
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/change")
    public Result deleteFollow(@PathParam("uid") int uid, @PathParam("followed") int followed)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/change?uid="+uid+"&followed="+followed,Result.class);
    }

    /**
     * description: 获取粉丝数
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/getFanNum/{id}")
    public Result getFanNum(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/getFanNum/"+id,Result.class);
    }

    /**
     * description: 获取关注数
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/getFollowNum/{id}")
    public Result getFollowNum(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/getFollowNum/"+id,Result.class);
    }

    @GetMapping("/follow/check")
    public Result checkFollow(@PathParam("uid") int uid, @PathParam("followed") int followed){
        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/check?uid="+uid+"&followed="+followed,Result.class);
    }

}
