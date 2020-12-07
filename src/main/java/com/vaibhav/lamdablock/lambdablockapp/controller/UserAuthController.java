package com.vaibhav.lamdablock.lambdablockapp.controller;

import com.vaibhav.lamdablock.lambdablockapp.LambdaBlockAppApplication;
import com.vaibhav.lamdablock.lambdablockapp.model.JwtRequest;
import com.vaibhav.lamdablock.lambdablockapp.model.UserDto;
import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.model.UserResponse;
import com.vaibhav.lamdablock.lambdablockapp.security.JwtTokenUtil;
import com.vaibhav.lamdablock.lambdablockapp.security.UserDetailsServiceimpl;
import com.vaibhav.lamdablock.lambdablockapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.vaibhav.lamdablock.lambdablockapp.security.JwtTokenUtil.JWT_TOKEN_VALIDITY;

@RestController
public class UserAuthController {

    private static final Logger LOGGER = LogManager.getLogger(UserAuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceimpl userDetailsServiceimpl;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        try{
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = userDetailsServiceimpl
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok().body(getUserResponse("success", "", token, JWT_TOKEN_VALIDITY));
        } catch (Exception e){
            LOGGER.error("Unable to authenticate user");
            return ResponseEntity.badRequest()
                    .body(getUserResponse("failed",
                            "Invalid Username or Password",
                            "", 0));
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok(userDetailsServiceimpl.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    private UserResponse getUserResponse(String status, String error, String token, long expiresInMins){
        UserResponse userResponse = UserResponse.builder()
                .status(status)
                .error(error)
                .authToken(token)
                .expiresInMinutes(expiresInMins)
                .build();
        return userResponse;
    }

}


