package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Notice;
import com.test.service.NoticeService;
import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author numsi
 * @date 2020/4/28 20:39
 */
@RestController
public class NoticeProvider {
    /*
    通知相关接口
     */

    @Autowired
    NoticeService noticeService;

    /**
     * description: 获得用户所有有关通知
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/list")
    public Result getAll(@PathParam("id") int id, @PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        Notice notice=new Notice();
        notice.setNoticeReciver(id);
        List<Notice> notices=noticeService.queryAllByItem(notice);
        PageInfo<Notice> pageInfo =new PageInfo<>(notices);
        return ResultFactory.buildSuccessResult(pageInfo);
    }

    /**
     * description: 删除某一通知
     *
     * @param nid
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/delete/{id}")
    public Result deleteNotice(@PathVariable("id") int id)
    {
        return ResultFactory.buildSuccessResult(noticeService.deleteById(id));
    }

    /**
     * description: 新增通知内容
     *
     * @param receiver
     * @param content
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/add")
    public Result addNotice(@PathParam("receiver")int receiver,@PathParam("content")String content)
    {
        Notice notice=new Notice();
        notice.setNoticeReciver(receiver);
        notice.setNoticeContent(content);
        notice.setNoticeState(0);
        return ResultFactory.buildSuccessResult(noticeService.insert(notice));
    }

    /**
     * description: 更新通知状态  更新为已读
     *
     * @param id
     * @return com.test.utils.Result
     */
    @GetMapping("/notice/update/{id}")
    public Result updateNotice(@PathVariable("id") int id)
    {
        Notice notice=noticeService.queryById(id);
        notice.setNoticeState(1);
        return ResultFactory.buildSuccessResult(noticeService.update(notice));
    }
}
