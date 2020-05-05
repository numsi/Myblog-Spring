package com.test.dao;

import com.test.entity.View;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (View)表数据库访问层
 *
 * @author numsi
 * @since 2020-05-05 09:53:13
 */
  @Mapper
public interface ViewDao {

    /**
     * 通过ID查询单条数据
     *
     * @param viewId 主键
     * @return 实例对象
     */
    View queryById(Integer viewId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<View> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param view 实例对象
     * @return 对象列表
     */
    List<View> queryAllByItem(View view);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-05 09:53:13
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<View> queryAll();

    /**
     * 新增数据
     *
     * @param view 实例对象
     * @return 影响行数
     */
    int insert(View view);

    /**
     * 修改数据
     *
     * @param view 实例对象
     * @return 影响行数
     */
    int update(View view);

    /**
     * 通过主键删除数据
     *
     * @param viewId 主键
     * @return 影响行数
     */
    int deleteById(Integer viewId);

}