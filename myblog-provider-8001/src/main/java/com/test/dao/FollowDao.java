package com.test.dao;

import com.test.entity.Follow;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Follow)表数据库访问层
 *
 * @author numsi
 * @since 2020-04-28 19:23:23
 */
  @Mapper
public interface FollowDao {

    /**
     * 通过ID查询单条数据
     *
     * @param followId 主键
     * @return 实例对象
     */
    Follow queryById(Integer followId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Follow> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param follow 实例对象
     * @return 对象列表
     */
    List<Follow> queryAllByItem(Follow follow);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-28 19:23:23
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Follow> queryAll();

    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 影响行数
     */
    int insert(Follow follow);

    /**
     * 修改数据
     *
     * @param follow 实例对象
     * @return 影响行数
     */
    int update(Follow follow);

    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 影响行数
     */
    int deleteById(Integer followId);

}