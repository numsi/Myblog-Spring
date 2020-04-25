package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Notice implements Serializable {
    private static final long serialVersionUID = -92328311745134992L;
    /**
    * 通知id
    */
    private Integer noticeId;
    /**
    * 通知内容
    */
    private String noticeContent;
    /**
    * 接收者
    */
    private Integer noticeReciver;
    /**
    * 0表示未读  1表示已读
    */
    private Integer noticeState;




}