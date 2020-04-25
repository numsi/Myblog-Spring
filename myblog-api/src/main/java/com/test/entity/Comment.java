package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Comment implements Serializable {
    private static final long serialVersionUID = 148643773740626017L;
    /**
    * 评论ID
    */
    private Integer commentId;
    /**
    * 评论创建日期
    */
    private Date commentCreattime;
    /**
    * 评论更新日期
    */
    private Date commentUpdate;
    /**
    * 评论内容
    */
    private String commentContent;
    /**
    * 作者ID
    */
    private Integer commentAuthor;
    /**
    * 文章ID
    */
    private Integer commentBlog;
    /**
    * 父评论ID
    */
    private Integer commentParent;




}