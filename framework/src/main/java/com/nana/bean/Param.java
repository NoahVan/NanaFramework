package com.nana.bean;

import com.nana.util.CastUtil;

import java.util.Map;

/**
* @Description:    java类作用描述:请求参数对象
* @Author:         yc
* @CreateDate:     2019/2/20 16:16
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 16:16
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }

    public int getInt(String name){
        return CastUtil.castInt(paramMap.get(name));
    }

    public boolean getBoolean(String name){
        return CastUtil.castBoolean(paramMap.get(name));
    }

    public double getDouble(String name){
        return CastUtil.castDouble(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
