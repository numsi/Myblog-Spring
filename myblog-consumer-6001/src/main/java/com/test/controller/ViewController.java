package com.test.controller;

import com.test.entity.View;
import com.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author numsi
 * @date 2020/5/1 21:28
 */
@RestController
public class ViewController {
    /*
    阅读相关接口
     */

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    /**
     * description: 添加一条阅读记录
     *
     * @param view
     * @return com.test.utils.Result
     */
    @PostMapping("/view/add")
    public Result addView(View view)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/view/add",view,Result.class);
    }
}
