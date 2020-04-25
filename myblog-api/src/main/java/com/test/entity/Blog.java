package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Blog)实体类
 *
 * @author numsi
 * @since 2020-04-25 19:28:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Blog implements Serializable {
    private static final long serialVersionUID = 215991603904711870L;
    /**
    * 博文ID
    */
    private Integer blogId;
    /**
    * 博文标题
    */
    private String blogTitle;
    /**
    * 博文发布时间
    */
    private Date blogCreattime;
    /**
    * 博文最后更新时间
    */
    private Date blogUpdatetime;
    /**
    * 博文作者ID
    */
    private Integer blogAuthor;
    /**
    * 博文html内容
    */
    private String blogContentHtml;
    /**
    * 博文md内容
    */
    private String blogContentMd;
    /**
    * 博文发布类型 0公开 1仅粉丝 2私密
    */
    private Integer blogReleaseType;
    /**
    * 博文分类
    */
    private String blogKind;
    /**
    * 博文标签
    */
    private String blogTags;
    /**
    * 被举报次数
    */
    private Integer blogReport;
    /**
    * 博文摘要
    */
    private String blogAbstract;
    /**
    * 博文封面
    */
    private String blogCover;



}