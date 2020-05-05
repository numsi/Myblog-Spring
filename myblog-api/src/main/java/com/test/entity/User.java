package com.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author numsi
 * @since 2020-05-04 23:06:13
 */
public class User implements Serializable {
    private static final long serialVersionUID = -74021166383622355L;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 用户名
    */
    private String userUsername;
    /**
    * 用户密码
    */
    private String userPassword;
    /**
    * 用户昵称
    */
    private String userNickname;
    /**
    * 用户创建时间
    */
    private Date userCreattime;
    /**
    * 用户性别 0：男 1：女   null为未知
    */
    private Integer userGender;
    /**
    * 用户手机号
    */
    private String userPhone;
    /**
    * 用户email
    */
    private String userEmail;
    /**
    * 用户头像url
    */
    private String userImgUrl;
    /**
    * 用户简介
    */
    private String userIntroduction;
    /**
    * 用户账号状态 0为正常 1为封禁
    */
    private Integer uerAbled;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Date getUserCreattime() {
        return userCreattime;
    }

    public void setUserCreattime(Date userCreattime) {
        this.userCreattime = userCreattime;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public Integer getUerAbled() {
        return uerAbled;
    }

    public void setUerAbled(Integer uerAbled) {
        this.uerAbled = uerAbled;
    }

}