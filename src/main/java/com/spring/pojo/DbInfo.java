package com.spring.pojo;

/**
 * @description:数据库链接信息
 * @author: Cherry
 * @time: 2020/6/4 15:35
 */
public class DbInfo {
    private String uri;
    private String driverName;
    private String username;
    private String password;
    /*<constructor-arg index="0" value=""/>*/
    public DbInfo(String uri, String driverName, String username, String password) {
        this.uri = uri;
        this.driverName = driverName;
        this.username = username;
        this.password = password;
    }

    public DbInfo() {
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
