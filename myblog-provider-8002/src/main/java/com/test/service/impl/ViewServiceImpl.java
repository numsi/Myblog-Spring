package com.test.service.impl;

import com.test.entity.View;
import com.test.dao.ViewDao;
import com.test.service.ViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (View)表服务实现类
 *
 * @author numsi
 * @since 2020-05-05 09:53:14
 */
@Service("viewService")
public class ViewServiceImpl implements ViewService {
    @Resource
    private ViewDao viewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param viewId 主键
     * @return 实例对象
     */
    @Override
    public View queryById(Integer viewId) {
        return this.viewDao.queryById(viewId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<View> queryAllByLimit(int offset, int limit) {
        return this.viewDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param view 实例对象
     * @return 实例对象
     */
    @Override
    public View insert(View view) {
        this.viewDao.insert(view);
        return view;
    }

    /**
     * 修改数据
     *
     * @param view 实例对象
     * @return 实例对象
     */
    @Override
    public View update(View view) {
        this.viewDao.update(view);
        return this.queryById(view.getViewId());
    }

    /**
     * 通过主键删除数据
     *
     * @param viewId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer viewId) {
        return this.viewDao.deleteById(viewId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-05-05 09:53:14
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<View> queryAll() {
        return viewDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param view 实例对象
     * @return 实例对象
     */
    @Override
    public List<View> queryAllByItem(View view) {
        return this.viewDao.queryAllByItem( view);
    }
}