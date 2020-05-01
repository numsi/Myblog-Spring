package com.test.controller;

import com.test.entity.Like;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/5/1 21:17
 */
@RestController
public class LikeController {
    /*
    点赞相关的接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    /**
     * description: 用户点赞博文
     *
     * @param like
     * @return com.test.utils.Result
     */
    @PostMapping("/like/add")
    public Result addLike(Like like)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/like/add",like,Result.class);
    }

    /**
     * description: 用户取消点赞
     *
     * @param blogId 博文ID
     * @param userId  用户ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/delete")
    public Result deleteLike(@PathParam("blogId") int blogId, @PathParam("userId") int userId)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/like/delete?blogId="+blogId+"&userId="+userId,Result.class);
    }

    /**
     * description: 检查用户是否点赞该文章，message中为not则为未点赞  have则为已点赞
     *
     * @param blogId 博文ID
     * @param userId  用户ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/check")
    public Result checkLike(@PathParam("blogId") int blogId, @PathParam("userId") int userId)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/like/check?blogId="+blogId+"&userId="+userId,Result.class);
    }

    /**
     * description: 获取某一博文的点赞数
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/getBlog/{id}")
    public Result getBlog(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/like/getBlog/"+id,Result.class);
    }

    /**
     * description: 获取某一用户的点赞总数
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/like/getUser/{id}")
    public Result getUser(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/like/getUser/"+id,Result.class);
    }


}
