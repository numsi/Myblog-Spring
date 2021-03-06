package com.test.service;

import com.test.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author numsi
 * @since 2020-05-04 23:06:27
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-04 23:06:27
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<User> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param user 实例对象
     * @return 实例对象
     */
    List<User> queryAllByItem(User user);

}