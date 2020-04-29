package com.test.controller;

import com.test.entity.View;
import com.test.service.ViewService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author numsi
 * @date 2020/4/29 21:41
 */
@RestController
public class ViewProvider {
    /*
    阅读相关接口
     */

    @Autowired
    ViewService viewService;

    /**
     * description: 新增阅读记录
     *
     * @param view
     * @return com.test.utils.Result
     */
    @PostMapping("/view/add")
    public Result addView(@RequestBody View view)
    {
        View res = viewService.insert(view);
        if(res==null)
        {
            return ResultFactory.buildFailResult("已阅读");
        }
        return ResultFactory.buildSuccessResult(null);
    }

    /**
     * description: 根据博文ID获取博文点赞数
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/getBlog/{id}")
    public Result getUser(@PathVariable("id") int id)
    {
        View view=new View();
        view.setViewBlog(id);
        List<View> views = viewService.queryAllByItem(view);
        if(views==null||views.size()==0)
        {
            return ResultFactory.buildSuccessResult(0);
        }
        return ResultFactory.buildSuccessResult(views.size());
    }


}
