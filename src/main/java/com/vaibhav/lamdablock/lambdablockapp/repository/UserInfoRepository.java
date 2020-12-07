package com.vaibhav.lamdablock.lambdablockapp.repository;

import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("SELECT u from UserInfo u where u.username=:username")
    public Optional<UserInfo> userNameExists(String username);
}
