package com.spring.pojo;

/**
 * @description:POJO
 * @author: Cherry
 * @time: 2020/6/5 8:52
 */
public class LogInfo {
    private int id;
    private String content;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public LogInfo(int id, String content, String createTime) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
    }
}
