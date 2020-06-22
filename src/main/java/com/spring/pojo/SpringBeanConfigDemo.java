package com.spring.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @description:spring-cfg.xml的bean配置演示
 * @author: Cherry
 * @time: 2020/6/5 9:41
 */
public class SpringBeanConfigDemo {
    private int id;
    private List<String> list;
    private List<LogInfo> logList;
    private Map<String,DbInfo> map;
    private Properties prop;
    private Set<String> set;
    private String[] array;

    public Map<String, DbInfo> getMap() {
        return map;
    }

    public void setMap(Map<String, DbInfo> map) {
        this.map = map;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<LogInfo> getLogList() {
        return logList;
    }

    public void setLogList(List<LogInfo> logList) {
        this.logList = logList;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }
}
