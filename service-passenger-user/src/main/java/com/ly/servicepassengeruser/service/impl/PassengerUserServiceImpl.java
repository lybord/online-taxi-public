package com.ly.servicepassengeruser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.servicepassengeruser.domain.PassengerUser;
import com.ly.servicepassengeruser.service.PassengerUserService;
import com.ly.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lybord
* @description 针对表【passenger_user】的数据库操作Service实现
* @createDate 2026-07-10 17:09:49
*/
@Service
public class PassengerUserServiceImpl extends ServiceImpl<PassengerUserMapper, PassengerUser>
    implements PassengerUserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

}




