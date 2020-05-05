package com.test.controller;

import com.test.entity.Like;
import com.test.service.LikeService;
import com.test.utils.ListUtis;
import com.test.utils.Result;
import com.test.utils.ResultCode;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author numsi
 * @date 2020/4/29 21:25
 */
@RestController
public class LikeProvider {
    /*
    用户点赞相关接口
     */

    @Autowired
    LikeService likeService;


    /**
     * description: 改变点赞状态
     *
     * @param blogId 博文ID
     * @param userId  用户ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/change")
    public Result deleteLike(@PathParam("blogId") Integer blogId, @PathParam("userId") Integer userId)
    {
        Like like=new Like();
        like.setLikeBlog(blogId);
        like.setLikeUser(userId);
        List<Like> likes = likeService.queryAllByItem(like);
        if(ListUtis.isNotNullEmpty(likes))
        {
            Like tep = likes.get(0);
            return ResultFactory.buildSuccessResult(likeService.deleteById(tep.getLikeId()));
        }

        return ResultFactory.buildSuccessResult(likeService.insert(like));
    }

    /**
     * description: 检查是否点赞
     *
     * @param blogId
     * @param userId
     * @return com.test.utils.Result
     */
    @GetMapping("/like/check")
    public Result checkLike(@PathParam("blogId") Integer blogId, @PathParam("userId") Integer userId)
    {
        Like like=new Like();
        like.setLikeBlog(blogId);
        like.setLikeUser(userId);
        List<Like> likes = likeService.queryAllByItem(like);
        if(ListUtis.isNotNullEmpty(likes))
        {
            return ResultFactory.buildResult(ResultCode.SUCCESS,"have",null);
        }
        return ResultFactory.buildResult(ResultCode.FAIL,"not",null);
    }

    /**
     * description: 获得某一博文的点赞数
     *
     * @param id  博文ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/getBlog/{id}")
    public Result getBlog(@PathVariable("id") int id)
    {
        Like like=new Like();
        like.setLikeBlog(id);
        List<Like> likes = likeService.queryAllByItem(like);
        if(likes==null||likes.size()==0)
        {
            return ResultFactory.buildSuccessResult(0);
        }
        return ResultFactory.buildSuccessResult(likes.size());
    }

    /**
     * description: 获取某一用户的总点赞数
     *
     * @param id 用户ID
     * @return com.test.utils.Result
     */
    @GetMapping("/like/getUser/{id}")
    public Result getUser(@PathVariable("id") int id)
    {
        Like like=new Like();
        like.setLikeUser(id);
        List<Like> likes = likeService.queryAllByItem(like);
        if(likes==null||likes.size()==0)
        {
            return ResultFactory.buildSuccessResult(0);
        }
        return ResultFactory.buildSuccessResult(likes.size());
    }


}
