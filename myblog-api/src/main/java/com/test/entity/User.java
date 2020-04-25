package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class User implements Serializable {
    private static final long serialVersionUID = -91170410608681331L;
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
    * 用户性别 0：未知 1：男 2：女
    */
    private Integer userGender;
    /**
    * 用户生日
    */
    private Date userBirth;
    /**
    * 用户email
    */
    private String userEmail;
    /**
    * 用户头像url
    */
    private String userImgUrl;



}