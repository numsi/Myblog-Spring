package com.test.service.impl;

import com.test.entity.Comment;
import com.test.dao.CommentDao;
import com.test.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author numsi
 * @since 2020-04-29 20:22:52
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer commentId) {
        return this.commentDao.queryById(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentDao.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.commentDao.deleteById(commentId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:22:52
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAll() {
        return commentDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public List<Comment> queryAllByItem(Comment comment) {
        return this.commentDao.queryAllByItem( comment);
    }
}