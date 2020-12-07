package com.vaibhav.lamdablock.lambdablockapp.security;

import com.vaibhav.lamdablock.lambdablockapp.model.UserDto;
import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserDetailsServiceimpl implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = userInfoRepository.userNameExists(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.get().getUsername(), user.get().getPassword(),
                new ArrayList<>());
    }

    public UserInfo save(UserDto user) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userInfoRepository.save(newUser);
    }
}
