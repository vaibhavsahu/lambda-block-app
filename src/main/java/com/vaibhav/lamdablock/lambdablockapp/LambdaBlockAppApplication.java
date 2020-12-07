package com.vaibhav.lamdablock.lambdablockapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.service.UserService;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@EnableJpaRepositories(basePackages = "com.vaibhav.lamdablock.lambdablockapp")
@SpringBootApplication
public class LambdaBlockAppApplication {
    private static final Logger LOGGER = LogManager.getLogger(LambdaBlockAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LambdaBlockAppApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserService userService){
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//
//            TypeReference<List<UserInfo>> typeReference = new TypeReference<List<UserInfo>>() {};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/users.json");
//            try{
//                List<UserInfo> users = mapper.readValue(inputStream, typeReference);
//                LOGGER.info("Loaded " + users.size()+" users from json");
//                userService.saveAll(users);
//                LOGGER.info("Saved users to DB");
//            } catch (IOException e){
//                LOGGER.error("An exception has occurred while saving users to DB"+ e);
//            }
//        };
//    }
}
