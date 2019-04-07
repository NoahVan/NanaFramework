package com.nana.helper;

import com.nana.ConfigConstant;
import com.nana.util.PropsUtil;

import java.util.Properties;

/**
* @Description:    java类作用描述:属性文件助手
* @Author:         yc
* @CreateDate:     2019/2/16 10:10
* @UpdateUser:     yc
* @UpdateDate:     2019/2/16 10:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public final class ConfigHelper {

    private static final Properties PROPERTIES = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    public static String getAppAssetPath(){
        return PropsUtil.getString(PROPERTIES, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }
}
