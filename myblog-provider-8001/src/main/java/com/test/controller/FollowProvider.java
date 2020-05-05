package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Follow;
import com.test.entity.User;
import com.test.service.FollowService;
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
 * @date 2020/4/28 19:25
 */
@RestController
public class FollowProvider {
    /*
    用户关注相关接口
     */

    @Autowired
    FollowService followService;


    /**
     * description:  根据用户ID获取关注列表
     *
     * @param id  用户id
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/get")
    public Result queryById(@PathParam("id") int id,@PathParam("pageNum") int pageNum,@PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Follow follow=new Follow();
        follow.setFollowFanid(id);
        List<Follow> follows=followService.queryAllByItem(follow);
        PageInfo<Follow> pageInfo =new PageInfo<>(follows);
        return ResultFactory.buildSuccessResult(pageInfo);
    }


    /**
     * description: 改变关注状态
     *
     * @param userid 用户ID
     * @param followed  被关注者ID
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/change")
    public Result deleteUser(@PathParam("uid") int uid, @PathParam("followed") int followed)
    {
        Follow follow =new Follow();
        follow.setFollowFanid(uid);
        follow.setFollowFollowerid(followed);
        List<Follow> follows=followService.queryAllByItem(follow);
        if(ListUtis.isNotNullEmpty(follows))
        {
            Follow temp = follows.get(0);

            return ResultFactory.buildSuccessResult(followService.deleteById(temp.getFollowId()));
        }

        return ResultFactory.buildSuccessResult(followService.insert(follow));
    }

    /**
     * description: 检查是否已关注
     *
     * @param user
     * @param followed
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/check")
    public Result checkFollow(@PathParam("uid") int uid, @PathParam("followed") int followed)
    {
        Follow follow =new Follow();
        follow.setFollowFanid(uid);
        follow.setFollowFollowerid(followed);
        List<Follow> follows=followService.queryAllByItem(follow);
        if(ListUtis.isNotNullEmpty(follows))
        {
            return ResultFactory.buildResult(ResultCode.SUCCESS,"have",null);
        }
        return ResultFactory.buildResult(ResultCode.FAIL,"not",null);
    }


    /**
     * description: 获取粉丝数
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/getFanNum/{id}")
    public Result getFanNum(@PathVariable("id") int id)
    {
        Follow follow =new Follow();
        follow.setFollowFollowerid(id);
        List<Follow> follows = followService.queryAllByItem(follow);
        if(ListUtis.isNotNullEmpty(follows))
        {
            return ResultFactory.buildSuccessResult(follows.size());
        }
        return ResultFactory.buildSuccessResult(0);
    }

    /**
     * description: 获取关注数
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/getFollowNum/{id}")
    public Result getFollowNum(@PathVariable("id") int id)
    {
        Follow follow =new Follow();
        follow.setFollowFanid(id);
        List<Follow> follows = followService.queryAllByItem(follow);
        if(ListUtis.isNotNullEmpty(follows))
        {
            return ResultFactory.buildSuccessResult(follows.size());
        }
        return ResultFactory.buildSuccessResult(0);
    }

}
