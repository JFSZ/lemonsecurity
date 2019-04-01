package com.zzidc.web.lambda;

import org.junit.Test;

/**
 * @ClassName LambdaTest
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 15:01
 **/
public class LambdaTest {
    public void test(){
        Converter<String,Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer conver(String from) {
                return Integer.valueOf(from);
            }
        };
        System.out.println(converter);

        Converter<String,Integer> converter1 = (param)-> Integer.valueOf(param);
    }
}
