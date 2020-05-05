package com.test.entity;

import java.io.Serializable;

/**
 * (Like)实体类
 *
 * @author numsi
 * @since 2020-05-05 10:14:32
 */
public class Like implements Serializable {
    private static final long serialVersionUID = 679744521828700255L;
    /**
    * 点赞id
    */
    private Integer likeId;
    /**
    * 博文id
    */
    private Integer likeBlog;
    /**
    * 用户ID
    */
    private Integer likeUser;


    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getLikeBlog() {
        return likeBlog;
    }

    public void setLikeBlog(Integer likeBlog) {
        this.likeBlog = likeBlog;
    }

    public Integer getLikeUser() {
        return likeUser;
    }

    public void setLikeUser(Integer likeUser) {
        this.likeUser = likeUser;
    }

}