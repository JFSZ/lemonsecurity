package com.zzidc.web.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName IdCardUtils
 * @Author chenxue
 * @Description TODO
 * @Date 2019/3/29 17:37
 **/
public class IdCardUtils {
    public static boolean isValidIdCard(String value){
        String regex = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return value.matches(regex);
    }
}
