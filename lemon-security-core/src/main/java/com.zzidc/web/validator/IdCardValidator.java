package com.zzidc.web.validator;

import com.zzidc.web.service.IdCardValidatorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName IdCardValidator
 * @Author chenxue
 * @Description  校验注解的校验逻辑
 * @Date 2019/3/29 17:23
 **/
public class IdCardValidator implements ConstraintValidator<IsIdCard,String>{
    @Autowired
    private IdCardValidatorService idCardValidatorService;
    /*
    * @Author chenxue
     * @Description 校验前的初始化工作
     * @Date 2019/3/29 17:27
     * @Param [isIdCard]
     * @return void
     **/
    @Override
    public void initialize(IsIdCard isIdCard) {
        String message = isIdCard.message();
        System.out.println("自定义的message信息是:".concat(message));
    }

    /*
     * @Description 具体的校验逻辑
     * @Date 2019/3/29 17:29
     * @Param [s, constraintValidatorContext]
     * @return boolean
     **/
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return idCardValidatorService.volid(s);
    }
}
