package com.zzidc.web.controller;

import lombok.Data;

/**
 * @ClassName FileInfo
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 10:51
 **/
@Data
public class FileInfo {
    private String filePath;

    public FileInfo(String filePath) {
        this.filePath = filePath;
    }
}
