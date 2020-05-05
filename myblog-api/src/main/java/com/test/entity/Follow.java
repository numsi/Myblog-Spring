package com.test.entity;

import java.io.Serializable;

/**
 * (Follow)实体类
 *
 * @author numsi
 * @since 2020-05-05 11:36:51
 */
public class Follow implements Serializable {
    private static final long serialVersionUID = -18863248026534463L;
    /**
    * 关注id
    */
    private Integer followId;
    /**
    * 被关注者ID
    */
    private Integer followFollowerid;
    /**
    * 粉丝ID
    */
    private Integer followFanid;


    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollowFollowerid() {
        return followFollowerid;
    }

    public void setFollowFollowerid(Integer followFollowerid) {
        this.followFollowerid = followFollowerid;
    }

    public Integer getFollowFanid() {
        return followFanid;
    }

    public void setFollowFanid(Integer followFanid) {
        this.followFanid = followFanid;
    }

}