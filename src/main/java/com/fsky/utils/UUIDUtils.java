package com.fsky.utils;

import java.util.UUID;

/**
 * Created by FDD on 2017/12/26.
 */
public class UUIDUtils {
    /**
     * 获得一个UUID
     * @return String UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
