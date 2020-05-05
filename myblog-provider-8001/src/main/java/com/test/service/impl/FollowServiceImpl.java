package com.test.service.impl;

import com.test.entity.Follow;
import com.test.dao.FollowDao;
import com.test.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Follow)表服务实现类
 *
 * @author numsi
 * @since 2020-05-05 11:37:10
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowDao followDao;

    /**
     * 通过ID查询单条数据
     *
     * @param followId 主键
     * @return 实例对象
     */
    @Override
    public Follow queryById(Integer followId) {
        return this.followDao.queryById(followId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Follow> queryAllByLimit(int offset, int limit) {
        return this.followDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    @Override
    public Follow insert(Follow follow) {
        this.followDao.insert(follow);
        return follow;
    }

    /**
     * 修改数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    @Override
    public Follow update(Follow follow) {
        this.followDao.update(follow);
        return this.queryById(follow.getFollowId());
    }

    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer followId) {
        return this.followDao.deleteById(followId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-05 11:37:10
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Follow> queryAll() {
        return followDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    @Override
    public List<Follow> queryAllByItem(Follow follow) {
        return this.followDao.queryAllByItem( follow);
    }
}