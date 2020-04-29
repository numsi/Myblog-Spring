package com.test.service;

import com.test.entity.View;
import java.util.List;

/**
 * (View)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:23:53
 */
public interface ViewService {

    /**
     * 通过ID查询单条数据
     *
     * @param viewId 主键
     * @return 实例对象
     */
    View queryById(Integer viewId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<View> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param view 实例对象
     * @return 实例对象
     */
    View insert(View view);

    /**
     * 修改数据
     *
     * @param view 实例对象
     * @return 实例对象
     */
    View update(View view);

    /**
     * 通过主键删除数据
     *
     * @param viewId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer viewId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:23:53
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<View> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param view 实例对象
     * @return 实例对象
     */
    List<View> queryAllByItem(View view);

}