package com.test.service.impl;

import com.test.entity.Blog;
import com.test.dao.BlogDao;
import com.test.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Blog)表服务实现类
 *
 * @author numsi
 * @since 2020-04-29 20:22:26
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    @Override
    public Blog queryById(Integer blogId) {
        return this.blogDao.queryById(blogId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Blog> queryAllByLimit(int offset, int limit) {
        return this.blogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog insert(Blog blog) {
        this.blogDao.insert(blog);
        return blog;
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog update(Blog blog) {
        this.blogDao.update(blog);
        return this.queryById(blog.getBlogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer blogId) {
        return this.blogDao.deleteById(blogId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-29 20:22:26
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Blog> queryAll() {
        return blogDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public List<Blog> queryAllByItem(Blog blog) {
        return this.blogDao.queryAllByItem( blog);
    }
}