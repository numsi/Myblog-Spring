package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Follow;
import com.test.entity.User;
import com.test.service.FollowService;
import com.test.utils.Result;
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
     * description: 添加关注
     *
     * @param follow
     * @return com.test.utils.Result
     */
    @PostMapping("/follow/add")
    public Result followAdd(@RequestBody Follow follow)
    {
        Follow res = followService.insert(follow);
        if(res==null)
        {
            return ResultFactory.buildFailResult("关注失败");
        }
        return ResultFactory.buildSuccessResult(res);
    }

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
     * description: 以用户ID与被关注者ID被参数  删除这条记录
     *
     * @param userid 用户ID
     * @param followed  被关注者ID
     * @return com.test.utils.Result
     */
    @GetMapping("/follow/delete")
    public Result deleteUser(@PathParam("user") int user, @PathParam("followed") int followed)
    {
        Follow follow =new Follow();
        follow.setFollowFanid(user);
        follow.setFollowFollowerid(followed);
        List<Follow> follows=followService.queryAllByItem(follow);
        if(follows==null)
        {
            return ResultFactory.buildFailResult("删除失败，请稍后再试");
        }
        if(followService.deleteById(follows.get(0).getFollowId()))
        {
            return ResultFactory.buildSuccessResult(null);
        }
        return ResultFactory.buildFailResult("删除失败，请稍后再试");
    }

}
