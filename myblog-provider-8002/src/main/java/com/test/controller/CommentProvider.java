package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Comment;
import com.test.service.CommentService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author numsi
 * @date 2020/4/30 19:17
 */
@RestController
public class CommentProvider {
    /*
    评论相关接口
     */

    @Autowired
    CommentService commentService;


    /**
     * description: 新增评论
     *
     * @param comment 评论
     * @return com.test.utils.Result
     */
    @PostMapping("/comment/add")
    public Result addComment(@RequestBody Comment comment)
    {
        Comment res=commentService.insert(comment);
        if(res==null)
        {
            return ResultFactory.buildFailResult("新增评论失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 修改评论内容
     *
     * @param comment
     * @return com.test.utils.Result
     */
    @PostMapping("/comment/update")
    public Result updateComment(@RequestBody Comment comment)
    {
        Comment res=commentService.update(comment);
        if(res==null)
        {
            return ResultFactory.buildFailResult("修改评论失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

    /**
     * description: 获得某一具体评论信息
     *
     * @param id  评论ID
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/get/{id}")
    public Result getOne(@PathVariable("id") int id)
    {
        Comment res=commentService.queryById(id);
        if(res==null)
        {
            return ResultFactory.buildFailResult("获取博文失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }


    /**
     * description: 获得某一用户的历史评论
     *
     * @param id 用户ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/listByUser")
    public Result listByUser(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Comment comment=new Comment();
        comment.setCommentAuthor(id);
        List<Comment> blogs = commentService.queryAllByItem(comment);
        PageInfo<Comment> pageInfo =new PageInfo<>(blogs);
        return ResultFactory.buildSuccessResult(pageInfo);

    }


    /**
     * description: 获得某一博文所有评论
     *
     * @param id 博文ID
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/listByBlog")
    public Result listByBlog(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Comment comment=new Comment();
        comment.setCommentBlog(id);
        List<Comment> blogs = commentService.queryAllByItem(comment);
        PageInfo<Comment> pageInfo =new PageInfo<>(blogs);
        return ResultFactory.buildSuccessResult(pageInfo);

    }


    /**
     * description: 删除用户评论  根据某一用户评论ID获得评论内容 将评论的作者更新为null 内容更新为""评论已被删除
     *
     * @param id 评论ID
     * @return com.test.utils.Result
     */
    @GetMapping("/comment/delete/{id}")
    public Result deleteComment(@PathVariable("id") int id)
    {
        Comment comment = commentService.queryById(id);
        comment.setCommentContent("评论已被删除");
        comment.setCommentAuthor(null);
        Comment res = commentService.update(comment);
        if(res==null)
        {
            return ResultFactory.buildFailResult("删除失败");
        }
        return ResultFactory.buildSuccessResult(null);
    }
}
