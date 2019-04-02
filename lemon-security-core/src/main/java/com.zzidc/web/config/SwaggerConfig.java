package com.zzidc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 16:07
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    /*
    * @Author chenxue
     * @Description //创建自定义API文档
     * @Date 2019/4/1 16:16
     * @Param []
     * @return springfox.documentation.spring.web.plugins.Docket
     **/
    @Bean
    public Docket createRestfulApiDocs(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzidc.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /*
    * @Author chenxue
     * @Description //TODO
     * @Date 2019/4/1 16:35
     * @Param []
     * @return springfox.documentation.service.ApiInfo
     **/
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("自定义RESTful接口文档")
                .description("测试")
                .termsOfServiceUrl("https://baidu.com")
                .contact(new Contact("Tom","https://baidu.com","843400447@qq.com"))
                .version("1.0.0")
                .build();
    }

    /*@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
     }*/
}
