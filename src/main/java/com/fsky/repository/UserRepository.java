package com.fsky.repository;

import com.fsky.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FDD on 2017/12/22.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);
}
