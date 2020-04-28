package com.test.dao;

import com.test.entity.Notice;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Notice)表数据库访问层
 *
 * @author numsi
 * @since 2020-04-28 19:23:50
 */
  @Mapper
public interface NoticeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    Notice queryById(Integer noticeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param notice 实例对象
     * @return 对象列表
     */
    List<Notice> queryAllByItem(Notice notice);

      /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-28 19:23:50
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Notice> queryAll();

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 影响行数
     */
    int deleteById(Integer noticeId);

}