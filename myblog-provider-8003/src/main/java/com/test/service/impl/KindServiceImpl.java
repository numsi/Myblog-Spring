package com.test.service.impl;

import com.test.entity.Kind;
import com.test.dao.KindDao;
import com.test.service.KindService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Kind)表服务实现类
 *
 * @author numsi
 * @since 2020-04-29 20:26:16
 */
@Service("kindService")
public class KindServiceImpl implements KindService {
    @Resource
    private KindDao kindDao;

    /**
     * 通过ID查询单条数据
     *
     * @param kindId 主键
     * @return 实例对象
     */
    @Override
    public Kind queryById(Integer kindId) {
        return this.kindDao.queryById(kindId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Kind> queryAllByLimit(int offset, int limit) {
        return this.kindDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    @Override
    public Kind insert(Kind kind) {
        this.kindDao.insert(kind);
        return kind;
    }

    /**
     * 修改数据
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    @Override
    public Kind update(Kind kind) {
        this.kindDao.update(kind);
        return this.queryById(kind.getKindId());
    }

    /**
     * 通过主键删除数据
     *
     * @param kindId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer kindId) {
        return this.kindDao.deleteById(kindId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:26:16
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Kind> queryAll() {
        return kindDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param kind 实例对象
     * @return 实例对象
     */
    @Override
    public List<Kind> queryAllByItem(Kind kind) {
        return this.kindDao.queryAllByItem( kind);
    }
}