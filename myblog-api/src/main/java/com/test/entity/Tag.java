package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Tag implements Serializable {
    private static final long serialVersionUID = -70866528600629579L;
    /**
    * 标签ID
    */
    private Integer tagId;
    /**
    * 标签名称
    */
    private String tagName;
    /**
    * 标签作者ID
    */
    private Integer tagAuthor;




}