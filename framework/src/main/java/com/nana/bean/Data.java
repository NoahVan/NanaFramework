package com.nana.bean;

/**
* @Description:    java类作用描述:返回数据对象
* @Author:         yc
* @CreateDate:     2019/2/20 16:26
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 16:26
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
