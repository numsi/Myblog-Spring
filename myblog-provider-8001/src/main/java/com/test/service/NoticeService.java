package com.test.service;

import com.test.entity.Notice;
import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author numsi
 * @since 2020-04-28 19:23:50
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    Notice queryById(Integer noticeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer noticeId);
    
       /**
     * @Description 查询全部数据
     * @author numsi
     * @date 2020-04-28 19:23:50
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Notice> queryAll();
    
        /**
     * 根据对象查找
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    List<Notice> queryAllByItem(Notice notice);

}