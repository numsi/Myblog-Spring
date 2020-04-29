package com.test.service.impl;

import com.test.entity.Admin;
import com.test.dao.AdminDao;
import com.test.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author numsi
 * @since 2020-04-29 20:25:57
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer adminId) {
        return this.adminDao.queryById(adminId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminId) {
        return this.adminDao.deleteById(adminId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:25:57
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAll() {
        return adminDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public List<Admin> queryAllByItem(Admin admin) {
        return this.adminDao.queryAllByItem( admin);
    }
}