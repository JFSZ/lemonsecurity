package com.zzidc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @ClassName AsyncController
 * @Author chenxue
 * @Description 异步处理REST服务
 * @Date 2019/4/1 13:41
 **/
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @RequestMapping("/order")
    public Callable<String> order(){
        Callable<String> result = ()->{
            logger.info("副线程开始");
            Thread.sleep(1000);
            logger.info("副线程返回");
            return "success";
        };
        logger.info("主线程返回");
        return result;
    }
    @RequestMapping("/syncOrder")
    public DeferredResult suncOrder(){

        return null;
    }
}
