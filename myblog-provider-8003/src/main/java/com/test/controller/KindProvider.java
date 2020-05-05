package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Kind;
import com.test.service.KindService;
import com.test.utils.ListUtis;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
        Kind temp =new Kind();
        temp.setKindName(kind.getKindName());
        List<Kind> res = kindService.queryAllByItem(temp);

        if(ListUtis.isNotNullEmpty(res))
        {
            return ResultFactory.buildFailResult("添加失败,已存在同名分类!");
        }
        return ResultFactory.buildSuccessResult(kindService.insert(kind));
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
        Kind temp =new Kind();
        temp.setKindName(kind.getKindName());
        List<Kind> res = kindService.queryAllByItem(temp);

        if(ListUtis.isNotNullEmpty(res))
        {
            return ResultFactory.buildFailResult("修改失败,已存在同名分类!");
        }
        return ResultFactory.buildSuccessResult(kindService.update(kind));
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

    @GetMapping("/kind/page")
    public Result listTag( @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<Kind> kinds = kindService.queryAll();
        PageInfo<Kind> pageInfo =new PageInfo<>(kinds);
        return ResultFactory.buildSuccessResult(pageInfo);
    }

    @GetMapping("/kind/delete/{id}")
    public Result deleteKind(@PathVariable("id") int id)
    {
        if(kindService.deleteById(id))
        {
            return ResultFactory.buildSuccessResult(null);
        }
        return ResultFactory.buildFailResult("删除失败");
    }
}
