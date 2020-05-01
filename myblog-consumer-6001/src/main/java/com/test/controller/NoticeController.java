package com.test.controller;

import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author numsi
 * @date 2020/5/1 21:40
 */
@RestController
public class NoticeController {
    /*
    通知相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * description: 获取某一用户的所有统治信息
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/list")
    public Result getAll(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/notice/list?id="+id+"&pageNum="+pageNum+"&pageSize="+pageSize,Result.class);
    }

    /**
     * description: 删除某一通知
     *
     * @param id  通知ID
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/delete/{id}")
    public Result deleteNotice(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/notice/delete/"+id,Result.class);
    }


    /**
     * description: 新增通知
     *
     * @param receiver 接收者ID
     * @param content 通知内容
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/add")
    public Result addNotice(@PathParam("receiver")int receiver,@PathParam("content")String content)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/notice/add?receiver="+receiver+"&content="+content,Result.class);
    }

    /**
     * description: 标记某一通知为已读
     *
     * @param id 通知ID
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/update/{id}")
    public Result updateNotice(@PathVariable("id") int id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/notice/update/"+id,Result.class);
    }
}
