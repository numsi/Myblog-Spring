package com.test.dao;

import com.test.entity.Blog;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Blog)表数据库访问层
 *
 * @author numsi
 * @since 2020-04-29 20:22:25
 */
  @Mapper
public interface BlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Integer blogId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Blog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blog 实例对象
     * @return 对象列表
     */
    List<Blog> queryAllByItem(Blog blog);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:22:25
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Blog> queryAll();

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 影响行数
     */
    int deleteById(Integer blogId);

}