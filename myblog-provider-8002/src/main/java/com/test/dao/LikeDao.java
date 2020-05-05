package com.test.dao;

import com.test.entity.Like;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Like)表数据库访问层
 *
 * @author numsi
 * @since 2020-05-05 10:14:50
 */
  @Mapper
public interface LikeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    Like queryById(Integer likeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Like> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param like 实例对象
     * @return 对象列表
     */
    List<Like> queryAllByItem(Like like);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-05 10:14:50
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Like> queryAll();

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int insert(Like like);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int update(Like like);

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 影响行数
     */
    int deleteById(Integer likeId);

}