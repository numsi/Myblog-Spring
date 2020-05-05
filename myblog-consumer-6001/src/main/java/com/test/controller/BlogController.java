package com.test.controller;

import com.test.entity.Blog;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/5/1 19:24
 */
@RestController
public class BlogController {
    /*
    博文相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    /**
     * description: 新增博文
     *
     * @param blog
     * @return com.test.utils.Result
     */
    @PostMapping("/blog/add")
    public Result addBlog(@RequestBody Blog blog)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/blog/add",blog,Result.class);
    }

    /**
     * description: 修改博文信息
     *
     * @param blog
     * @return com.test.utils.Result
     */
    @PostMapping("/blog/update")
    public Result updateBlog(@RequestBody Blog blog)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/blog/update",blog,Result.class);
    }

    /**
     * description: 获取某一博文的具体信息
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/get/{id}")
    public Result getOne(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/get/"+id,Result.class);
    }

    /**
     * description: 根据用户ID获取所有的博文列表
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/listByUser")
    public Result listByUser(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/listByUser?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 获取所有此标签的博文
     *
     * @param id 标签ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/listByTag")
    public Result listByTag(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/listByTag?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 获取所有此分类的博文信息
     *
     * @param id 博文分类ID ID为-1时获取所有的博文信息
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/listByKind")
    public Result listByKind(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/listByKind?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 删除某一具体博文
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/delete/{id}")
    public Result deleteBlog(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/delete/"+id,Result.class);
    }

    @GetMapping("/blog/search")
    public Result search(@PathParam("keyword") String keyword, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/blog/search?keyword="+keyword+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }
}
