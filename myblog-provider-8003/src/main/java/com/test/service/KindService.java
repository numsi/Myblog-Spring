package com.test.service;

import com.test.entity.Kind;
import java.util.List;

/**
 * (Kind)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:26:16
 */
public interface KindService {

    /**
     * 通过ID查询单条数据
     *
     * @param kindId 主键
     * @return 实例对象
     */
    Kind queryById(Integer kindId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Kind> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    Kind insert(Kind kind);

    /**
     * 修改数据
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    Kind update(Kind kind);

    /**
     * 通过主键删除数据
     *
     * @param kindId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer kindId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:26:16
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Kind> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    List<Kind> queryAllByItem(Kind kind);

}