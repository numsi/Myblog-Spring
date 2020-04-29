package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Blog;
import com.test.service.BlogService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author numsi
 * @date 2020/4/29 20:48
 */
@RestController
public class BlogProvider {

    /*
    博客正文相关接口
     */

    @Autowired
    BlogService blogService;

    /**
     * description: 新增博客
     *
     * @param blog
     * @return com.test.utils.Result
     */
    @PostMapping("/blog/add")
    public Result addBlog(@RequestBody Blog blog)
    {
        Blog res = blogService.insert(blog);
        if(res==null)
        {
            return ResultFactory.buildFailResult("新增博文失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 更新博文
     *
     * @param blog
     * @return com.test.utils.Result
     */
    @PostMapping("/blog/update")
    public Result updateBlog(@RequestBody Blog blog)
    {
        Blog res=blogService.update(blog);
        if(res==null)
        {
            return ResultFactory.buildFailResult("更新博文失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 获得具体某一文章
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/get/{id}")
    public Result getOne(@PathVariable("id") int id)
    {
        Blog res=blogService.queryById(id);
        if(res==null)
        {
            return ResultFactory.buildFailResult("获取博文失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 根据用户ID获取所有博文且分页
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/getAll")
    public Result getAll(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Blog blog=new Blog();
        blog.setBlogAuthor(id);
        List<Blog> blogs = blogService.queryAllByItem(blog);
        PageInfo<Blog> pageInfo =new PageInfo<>(blogs);
        return ResultFactory.buildSuccessResult(pageInfo);

    }

    /**
     * description: 获得全部的博文信息
     *
     * @param
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/list")
    public Result list()
    {
        List<Blog> res = blogService.queryAll();
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 删除某一博文
     *
     * @param id 博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/blog/delete/{id}")
    public Result deleteBlog(@PathVariable("id") int id)
    {
        if(blogService.deleteById(id))
        {
            return ResultFactory.buildSuccessResult(null);
        }
        return ResultFactory.buildFailResult("删除失败");
    }
}
