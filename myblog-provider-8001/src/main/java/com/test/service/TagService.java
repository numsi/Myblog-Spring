package com.test.service;

import com.test.entity.Tag;
import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:26:39
 */
public interface TagService {

    /**
     * 通过ID查询单条数据
     *
     * @param tagId 主键
     * @return 实例对象
     */
    Tag queryById(Integer tagId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Tag> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    Tag insert(Tag tag);

    /**
     * 修改数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    Tag update(Tag tag);

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tagId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:26:39
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Tag> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    List<Tag> queryAllByItem(Tag tag);

}