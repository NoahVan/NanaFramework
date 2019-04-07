package com.nana.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException(fileName + " file is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key){
        return getString(properties, key, "");
    }

    /**
     * 获取字符型属性（可指定默认值）
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if (properties.containsKey(key)){
            if (StringUtil.isNotEmpty(properties.getProperty(key))){
                value = properties.getProperty(key);
            }
        }
        return value;
    }

    public static int getInt(Properties properties, String key){
        return getInt(properties, key, 0);
    }

    public static int getInt(Properties properties, String key, int defaultValue){
        int value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties properties, String key){
        return getBoolean(properties, key, false);
    }

    public static boolean getBoolean(Properties properties, String key, boolean defaultValue){
        boolean value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }
}
