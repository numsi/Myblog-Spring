package com.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Blog)实体类
 *
 * @author numsi
 * @since 2020-05-01 19:33:17
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = -77544941011321861L;
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
    * 博文分类ID
    */
    private Integer blogKind;
    /**
    * 博文标签ID
    */
    private Integer blogTag;
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


    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Date getBlogCreattime() {
        return blogCreattime;
    }

    public void setBlogCreattime(Date blogCreattime) {
        this.blogCreattime = blogCreattime;
    }

    public Date getBlogUpdatetime() {
        return blogUpdatetime;
    }

    public void setBlogUpdatetime(Date blogUpdatetime) {
        this.blogUpdatetime = blogUpdatetime;
    }

    public Integer getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(Integer blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogContentHtml() {
        return blogContentHtml;
    }

    public void setBlogContentHtml(String blogContentHtml) {
        this.blogContentHtml = blogContentHtml;
    }

    public String getBlogContentMd() {
        return blogContentMd;
    }

    public void setBlogContentMd(String blogContentMd) {
        this.blogContentMd = blogContentMd;
    }

    public Integer getBlogReleaseType() {
        return blogReleaseType;
    }

    public void setBlogReleaseType(Integer blogReleaseType) {
        this.blogReleaseType = blogReleaseType;
    }

    public Integer getBlogKind() {
        return blogKind;
    }

    public void setBlogKind(Integer blogKind) {
        this.blogKind = blogKind;
    }

    public Integer getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(Integer blogTag) {
        this.blogTag = blogTag;
    }

    public Integer getBlogReport() {
        return blogReport;
    }

    public void setBlogReport(Integer blogReport) {
        this.blogReport = blogReport;
    }

    public String getBlogAbstract() {
        return blogAbstract;
    }

    public void setBlogAbstract(String blogAbstract) {
        this.blogAbstract = blogAbstract;
    }

    public String getBlogCover() {
        return blogCover;
    }

    public void setBlogCover(String blogCover) {
        this.blogCover = blogCover;
    }

}