package com.zzidc.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName FileController
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 10:43
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    private static String folder = "E:\\test";
    @PostMapping
    @ApiOperation(value = "文件上传接口",notes = "使用此接口上传文件")
    @ApiImplicitParam(name = "file",value = "使用MultipartFile的实例对象来接收文件数据",required = true,dataTypeClass = MultipartFile.class)
    public FileInfo uploadFile(@RequestParam MultipartFile file) throws IOException {
        System.out.println("上传文件");
        File newFile = new File(folder,System.currentTimeMillis() + ".txt");
        file.transferTo(newFile);
        return new FileInfo(newFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "文档下载接口",notes = "使用此接口下载文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "文件ID",dataTypeClass = String.class,required = true),
            @ApiImplicitParam(name = "request",value = "HttpServletRequest实例对象，自动注入，无需传递",required = true,dataTypeClass = HttpServletRequest.class),
            @ApiImplicitParam(name = "response",value = "HttpServletResponse实例对象",required = true,dataTypeClass = HttpServletResponse.class)
    })
    public void downLoadFile(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try(
                InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
                OutputStream outputStream = response.getOutputStream();
                ){
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=test.txt");
            byte[] bytes = new byte[1024];
            while(inputStream.read(bytes) != -1){
                outputStream.write(bytes);
            }
            //IoUtil.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
