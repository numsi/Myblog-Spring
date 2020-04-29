package com.test.service;

import com.test.entity.Comment;
import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:22:52
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Integer commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:22:52
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Comment> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    List<Comment> queryAllByItem(Comment comment);

}