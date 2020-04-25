package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Follow)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Follow implements Serializable {
    private static final long serialVersionUID = 802583304718735682L;
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




}