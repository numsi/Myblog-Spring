package com.test.service;

import com.test.entity.Like;
import java.util.List;

/**
 * (Like)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:23:15
 */
public interface LikeService {

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    Like queryById(Integer likeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Like> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    Like insert(Like like);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    Like update(Like like);

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer likeId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:23:15
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Like> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param like 实例对象
     * @return 实例对象
     */
    List<Like> queryAllByItem(Like like);

}