package com.test.service.impl;

import com.test.entity.Notice;
import com.test.dao.NoticeDao;
import com.test.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author numsi
 * @since 2020-04-28 19:23:50
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer noticeId) {
        return this.noticeDao.queryById(noticeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Notice> queryAllByLimit(int offset, int limit) {
        return this.noticeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getNoticeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer noticeId) {
        return this.noticeDao.deleteById(noticeId) > 0;
    }
    
            /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-28 19:23:50
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<Notice> queryAll() {
        return noticeDao.queryAll();
    }
    
        /**
     * 根据对象查找
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public List<Notice> queryAllByItem(Notice notice) {
        return this.noticeDao.queryAllByItem( notice);
    }
}