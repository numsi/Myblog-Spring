package com.test.service;

import com.test.entity.Blog;
import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author numsi
 * @since 2020-05-01 19:37:20
 */
public interface BlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Integer blogId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Blog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer blogId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-01 19:37:20
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Blog> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    List<Blog> queryAllByItem(Blog blog);

}