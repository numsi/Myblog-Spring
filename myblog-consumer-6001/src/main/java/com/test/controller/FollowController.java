package com.test.controller;

import com.test.entity.Follow;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
     * description: 新增关注
     *
     * @param follow
     * @return java.lang.String
     */
    @PostMapping("/follow/add")
    public Result followAdd(Follow follow)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/follow/add",follow,Result.class);
    }

    @GetMapping("/follow/delete")
    public Result deleteFollow(@PathParam("user") int user, @PathParam("followed") int followed)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/follow/delete?user="+user+"&followed="+followed,Result.class);
    }

}
