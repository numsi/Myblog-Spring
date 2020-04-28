package com.test.service;

import com.test.entity.Follow;
import java.util.List;

/**
 * (Follow)表服务接口
 *
 * @author numsi
 * @since 2020-04-28 19:23:23
 */
public interface FollowService {

    /**
     * 通过ID查询单条数据
     *
     * @param followId 主键
     * @return 实例对象
     */
    Follow queryById(Integer followId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Follow> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Follow insert(Follow follow);

    /**
     * 修改数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Follow update(Follow follow);

    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer followId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-28 19:23:23
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Follow> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    List<Follow> queryAllByItem(Follow follow);

}