package com.test.controller;

import com.test.entity.Tag;
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
 * @date 2020/5/1 19:08
 */
@RestController
public class TagController {
    /*
    博文标签相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * description: 新增博文标签
     *
     * @param tag
     * @return com.test.utils.Result
     */
    @PostMapping("/tag/add")
    public Result addTas(Tag tag)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/tag/add",tag,Result.class);
    }


    /**
     * description: 获取某一用户所有自定义博文标签且进行分页
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/tag/list")
    public Result listOnes(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/tag/list?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 删除某一博文标签
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/tag/delete/{id}")
    public Result deleteTag(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/tag/delete/"+id,Result.class);
    }

    /**
     * description: 更行博文标签信息
     *
     * @param tag
     * @return com.test.utils.Result
     */
    @PostMapping("/tag/update")
    public Result updateTag(Tag tag)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/tag/update",tag,Result.class);
    }
}
