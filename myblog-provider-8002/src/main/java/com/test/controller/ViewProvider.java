package com.test.controller;

import com.test.entity.View;
import com.test.service.ViewService;
import com.test.utils.ListUtis;
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
        List<View> views = viewService.queryAllByItem(view);
        if(ListUtis.isNotNullEmpty(views))
        {
            return ResultFactory.buildSuccessResult("");
        }
        return ResultFactory.buildSuccessResult(viewService.insert(view));
    }

    @GetMapping("/view/get/{id}")
    public Result getView(@PathVariable("id") int id)
    {
        View view=new View();
        view.setViewBlog(id);
        List<View> views = viewService.queryAllByItem(view);
        if(ListUtis.isNotNullEmpty(views))
        {
            return ResultFactory.buildSuccessResult(views.size());
        }
        return ResultFactory.buildSuccessResult(0);
    }

    @GetMapping("/view/getByUser/{id}")
    public Result getViewByUser(@PathVariable("id") int id)
    {
        View view=new View();
        view.setViewUser(id);
        List<View> views = viewService.queryAllByItem(view);
        if(ListUtis.isNotNullEmpty(views))
        {
            return ResultFactory.buildSuccessResult(views.size());
        }
        return ResultFactory.buildSuccessResult(0);
    }


}
