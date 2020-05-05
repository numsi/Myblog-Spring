package com.test.controller;

import com.test.entity.Kind;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/5/1 21:52
 */
@RestController
public class KindController {
    /*
    博文分类相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8003";

    /**
     * description: 新增博文分类
     *
     * @param kind
     * @return com.test.utils.Result
     */
    @PostMapping("/kind/add")
    public Result addKind(@RequestBody  Kind kind)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/kind/add",kind,Result.class);
    }

    /**
     * description: 修改博文分类信息
     *
     * @param kind
     * @return com.test.utils.Result
     */
    @PostMapping("/kind/update")
    public Result updateKind(@RequestBody Kind kind)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/kind/update",kind,Result.class);
    }

    @GetMapping("/kind/delete/{id}")
    public Result deleteKind(@PathVariable("id") int id)
    {

        return restTemplate.getForObject(REST_URL_PREFIX+"/kind/delete/"+id,Result.class);
    }

    /**
     * description: 获取所有的分类信息
     *
     * @param
     * @return com.test.utils.Result
     */
    @GetMapping("/kind/list")
    public Result getAll()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/kind/list",Result.class);
    }

    @GetMapping("/kind/page")
    public Result listTag(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/kind/page?pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }
}
