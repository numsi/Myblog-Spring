package com.test.controller;

import com.test.entity.Kind;
import com.test.service.KindService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author numsi
 * @date 2020/4/30 19:37
 */
@RestController
public class KindProvider {
    /*
    博文种类相关接口
     */

    @Autowired
    KindService kindService;

    /**
     * description: 添加新的博客分类
     *
     * @param kind
     * @return com.test.utils.Result
     */
    @PostMapping("/kind/add")
    public Result addKind(@RequestBody Kind kind)
    {
        Kind res=kindService.insert(kind);
        if(res==null)
        {
            return ResultFactory.buildFailResult("添加失败!");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 修改分类信息
     *
     * @param kind
     * @return com.test.utils.Result
     */
    @PostMapping("/kind/update")
    public Result updateKind(@RequestBody Kind kind)
    {
        Kind res=kindService.update(kind);
        if(res==null)
        {
            return ResultFactory.buildFailResult("修改失败!");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 获得所有已有的分类信息
     *
     * @param
     * @return com.test.utils.Result
     */
    @GetMapping("/kind/list")
    public Result getAll()
    {
        List<Kind> kinds = kindService.queryAll();
        return ResultFactory.buildSuccessResult(kinds);
    }
}
