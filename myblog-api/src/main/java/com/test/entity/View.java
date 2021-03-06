package com.test.entity;

import java.io.Serializable;

/**
 * (View)实体类
 *
 * @author numsi
 * @since 2020-05-05 09:53:05
 */
public class View implements Serializable {
    private static final long serialVersionUID = -57693480902774444L;
    /**
    * 阅读id
    */
    private Integer viewId;
    /**
    * 博文id
    */
    private Integer viewBlog;
    /**
    * 用户id
    */
    private Integer viewUser;


    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getViewBlog() {
        return viewBlog;
    }

    public void setViewBlog(Integer viewBlog) {
        this.viewBlog = viewBlog;
    }

    public Integer getViewUser() {
        return viewUser;
    }

    public void setViewUser(Integer viewUser) {
        this.viewUser = viewUser;
    }

}