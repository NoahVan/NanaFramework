package com.nana;

/**
* @Description:    java类作用描述:提供相关配置项常量
* @Author:         yc
* @CreateDate:     2019/2/16 10:07
* @UpdateUser:     yc
* @UpdateDate:     2019/2/16 10:07
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface ConfigConstant {
    String CONFIG_FILE = "nana.properties";

    String JDBC_DRIVER = "jdbcDriver";
    String JDBC_URL = "jdbcUrl";
    String JDBC_USERNAME = "jdbcUsername";
    String JDBC_PASSWORD = "jdbcPassword";

    String APP_BASE_PACKAGE = "basePackage";
    String APP_JSP_PATH = "jspPath";
    String APP_ASSET_PATH = "assetPath";
}
