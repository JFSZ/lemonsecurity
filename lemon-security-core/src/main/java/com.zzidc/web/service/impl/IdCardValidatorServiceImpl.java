package com.zzidc.web.service.impl;

import com.zzidc.web.service.IdCardValidatorService;
import com.zzidc.web.utils.IdCardUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName IdCardValidatorServiceImpl
 * @Author chenxue
 * @Description TODO
 * @Date 2019/3/29 17:35
 **/
@Service
public class IdCardValidatorServiceImpl implements IdCardValidatorService {
    @Override
    public boolean volid(String value) {
        return IdCardUtils.isValidIdCard(value);
    }
}
