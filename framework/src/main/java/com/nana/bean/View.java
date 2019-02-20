package com.nana.bean;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    java类作用描述:返回视图对象
* @Author:         yc
* @CreateDate:     2019/2/20 16:22
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 16:22
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        this.model = new HashMap<>();
    }

    public View addModel(String key, Object value){
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
