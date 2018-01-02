package com.fsky.repository;

import com.fsky.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FDD on 2017/12/22.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByUserName(String userName);
}
