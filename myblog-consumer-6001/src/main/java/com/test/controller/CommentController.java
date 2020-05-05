package com.test.controller;

import com.test.entity.Comment;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/5/1 21:06
 */
@RestController
public class CommentController {
    /*
    评论相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    /**
     * description: 新增博客评论
     *
     * @param comment
     * @return com.test.utils.Result
     */
    @PostMapping("/comment/add")
    public Result addBlog(@RequestBody Comment comment)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/comment/add",comment,Result.class);
    }

    /**
     * description: 更新评论内容
     *
     * @param comment
     * @return com.test.utils.Result
     */
    @PostMapping("/comment/update")
    public Result updateBlog(@RequestBody Comment comment)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/comment/update",comment,Result.class);
    }

    /**
     * description: 获取一个评论的具体内容
     *
     * @param id  评论的ID
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/get/{id}")
    public Result getOne(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/comment/get/"+id,Result.class);
    }

    /**
     * description: 获取某一用户的所有历史评论
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/listByUser")
    public Result listByUser(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/comment/listByUser?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 获取某一文章的所有评论信息
     *
     * @param id 博文ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/listByBlog")
    public Result listByBlog(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/comment/listByBlog?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 删除某一评论
     *
     * @param id  评论ID
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/delete/{id}")
    public Result deleteComment(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/comment/delete/"+id,Result.class);
    }

    @GetMapping("/comment/getBlog/{id}")
    public Result getBlog(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/comment/getBlog/"+id,Result.class);
    }

}
