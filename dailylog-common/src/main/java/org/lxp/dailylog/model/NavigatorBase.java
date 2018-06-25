package org.lxp.dailylog.model;

import static org.lxp.dailylog.util.DateUtil.TIMEZONE;
import static org.lxp.dailylog.util.DateUtil.yyyyMMddHHmm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class NavigatorBase {
    private Long seqid;

    @ApiModelProperty(value = "site name")
    private String name;

    @ApiModelProperty(value = "site link")
    private String url;

    @ApiModelProperty(value = "site title used for a label")
    private String title;

    @ApiModelProperty(value = "record creation time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = yyyyMMddHHmm, timezone = TIMEZONE)
    private Date createtime;

    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seqid=").append(seqid);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", title=").append(title);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}