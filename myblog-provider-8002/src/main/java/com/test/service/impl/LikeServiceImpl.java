package com.test.service.impl;

import com.test.entity.Like;
import com.test.dao.LikeDao;
import com.test.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Like)表服务实现类
 *
 * @author numsi
 * @since 2020-05-05 10:14:51
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeDao likeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    @Override
    public Like queryById(Integer likeId) {
        return this.likeDao.queryById(likeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Like> queryAllByLimit(int offset, int limit) {
        return this.likeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like insert(Like like) {
        this.likeDao.insert(like);
        return like;
    }

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like update(Like like) {
        this.likeDao.update(like);
        return this.queryById(like.getLikeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer likeId) {
        return this.likeDao.deleteById(likeId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-05 10:14:51
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Like> queryAll() {
        return likeDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public List<Like> queryAllByItem(Like like) {
        return this.likeDao.queryAllByItem( like);
    }
}