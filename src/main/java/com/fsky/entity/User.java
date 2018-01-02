package com.fsky.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by FDD on 2017/12/22.
 */
@Data
@Entity
public class User {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    private String userName;
    private String nickName;
    private String password;
    private int userType;
    private String createTime;
    private int state;
}
