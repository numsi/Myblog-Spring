package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Like)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Like implements Serializable {
    private static final long serialVersionUID = -25638527102417960L;
    /**
    * 点赞id
    */
    private Integer likeId;
    /**
    * 点赞内容
    */
    private Integer likeBlog;
    /**
    * 点赞作者
    */
    private Integer likeUsername;




}