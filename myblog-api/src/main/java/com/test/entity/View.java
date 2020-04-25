package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (View)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class View implements Serializable {
    private static final long serialVersionUID = -69673166521819935L;
    /**
    * 阅读id
    */
    private Integer viewId;
    /**
    * 博文id
    */
    private Integer viewBlog;
    /**
    * 用户名
    */
    private String viewUsername;



}