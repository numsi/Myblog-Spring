package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Tag;
import com.test.service.TagService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author numsi
 * @date 2020/4/29 20:35
 */
@RestController
public class TagProvider {
    /*
    用户自定义标签相关接口
     */

    @Autowired
    TagService tagService;

    /**
     * description: 新增用户自定义标签
     *
     * @param tag  标签对象
     * @return com.test.utils.Result
     */
    @PostMapping("/tag/add")
    public Result addTag(@RequestBody Tag tag)
    {
        List<Tag> tags=tagService.queryAllByItem(tag);
        if(tags!=null)
        {
            return ResultFactory.buildFailResult("已存在改标签");
        }
        return ResultFactory.buildSuccessResult(tagService.insert(tag));
    }

    /**
     * description: 修改用户标签
     *
     * @param tag
     * @return com.test.utils.Result
     */
    @PostMapping("/tag/update")
    public Result updateTag(@RequestBody Tag tag)
    {
        Tag res = tagService.update(tag);
        if(res==null)
        {
            return ResultFactory.buildFailResult("修改标签失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 根据标签ID 删除标签
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/tag/delete/{id}")
    public Result deleteTag(@PathVariable("id") int id)
    {
        if(tagService.deleteById(id))
        {
            return ResultFactory.buildSuccessResult(null);
        }
        return ResultFactory.buildFailResult("删除失败");
    }

    /**
     * description: 获得某一用户的所有标签且分页
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/tag/list")
    public Result listTag(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Tag tag=new Tag();
        tag.setTagAuthor(id);
        List<Tag> res = tagService.queryAllByItem(tag);
        PageInfo<Tag> pageInfo =new PageInfo<>(res);
        return ResultFactory.buildSuccessResult(pageInfo);
    }
}
