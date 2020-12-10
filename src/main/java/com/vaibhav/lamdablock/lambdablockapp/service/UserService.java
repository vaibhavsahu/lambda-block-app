package com.vaibhav.lamdablock.lambdablockapp.service;

import com.vaibhav.lamdablock.lambdablockapp.Entity.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public Iterable<UserInfo> saveAll(List<UserInfo> users){
        return userInfoRepository.saveAll(users);
    }

    public Optional<UserInfo> findUserName(String userName){
        return userInfoRepository.userNameExists(userName);
    }

    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

}
