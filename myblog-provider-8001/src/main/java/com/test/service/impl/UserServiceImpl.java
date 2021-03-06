package com.test.service.impl;

import com.test.entity.User;
import com.test.dao.UserDao;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author numsi
 * @since 2020-05-04 23:06:27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userDao.deleteById(userId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-04 23:06:27
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public List<User> queryAllByItem(User user) {
        return this.userDao.queryAllByItem( user);
    }
}