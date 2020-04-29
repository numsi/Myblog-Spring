package com.test.dao;

import com.test.entity.Kind;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Kind)表数据库访问层
 *
 * @author numsi
 * @since 2020-04-29 20:26:16
 */
  @Mapper
public interface KindDao {

    /**
     * 通过ID查询单条数据
     *
     * @param kindId 主键
     * @return 实例对象
     */
    Kind queryById(Integer kindId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Kind> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param kind 实例对象
     * @return 对象列表
     */
    List<Kind> queryAllByItem(Kind kind);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:26:16
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Kind> queryAll();

    /**
     * 新增数据
     *
     * @param kind 实例对象
     * @return 影响行数
     */
    int insert(Kind kind);

    /**
     * 修改数据
     *
     * @param kind 实例对象
     * @return 影响行数
     */
    int update(Kind kind);

    /**
     * 通过主键删除数据
     *
     * @param kindId 主键
     * @return 影响行数
     */
    int deleteById(Integer kindId);

}