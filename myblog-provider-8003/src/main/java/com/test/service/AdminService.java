package com.test.service;

import com.test.entity.Admin;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author numsi
 * @since 2020-04-29 20:25:57
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:25:57
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Admin> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    List<Admin> queryAllByItem(Admin admin);

}