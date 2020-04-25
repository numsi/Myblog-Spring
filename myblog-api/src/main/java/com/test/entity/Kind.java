package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Kind)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Kind implements Serializable {
    private static final long serialVersionUID = -66688130308076070L;
    /**
    * 分类ID
    */
    private Integer kindId;
    /**
    * 分类名称
    */
    private String kindName;




}