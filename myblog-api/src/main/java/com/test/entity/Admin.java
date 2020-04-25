package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Admin implements Serializable {
    private static final long serialVersionUID = -42495790773243610L;
    
    private Integer adminId;
    
    private String adminName;
    
    private String adminPassword;
    
    private String adminEmail;




}