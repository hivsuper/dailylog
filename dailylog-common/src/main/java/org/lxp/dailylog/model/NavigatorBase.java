package org.lxp.dailylog.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class NavigatorBase {
    private Long id;

    @ApiModelProperty(value = "site name")
    private String name;

    @ApiModelProperty(value = "site link")
    private String url;

    @ApiModelProperty(value = "site title used for a label")
    private String title;

    @ApiModelProperty(value = "record creation time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}