package com.zzidc.web.lambda;

/**
 * @ClassName Converter
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 14:57
 **/
@FunctionalInterface
public interface Converter<F,T> {
    T conver(F from);
}
