package com.nana.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* @Description:    java类作用描述:JSON与POJO之间的转换工具
* @Author:         yc
* @CreateDate:     2019/2/20 17:06
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 17:06
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public final class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private JsonUtil() {
    }

    public static <T> String encodeJson(T object) {
        String json;
        try {
            json = JSON.toJSONStringWithDateFormat(object, DATE_FORMAT, SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            LOGGER.error("convert POJO to JSON failure", e);
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T decodeJson(String json, Class<T> type) {
        T pojo;
        try {
            pojo = JSON.parseObject(json, type);
        } catch (Exception e) {
            LOGGER.error("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
        return pojo;
    }

    public static <T> List<T> decodeArrayJson(String json, Class<T> type) {
        List<T> list;
        try {
            list = JSON.parseArray(json, type);
        } catch (Exception e) {
            LOGGER.error("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
        return list;
    }
}
