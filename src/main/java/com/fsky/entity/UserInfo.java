package com.fsky.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by FDD on 2017/12/22.
 */
@Data
@Entity
public class UserInfo {
    @Id
    private String userName;
    private String phone;
    private String email;
    private String place;
    private String qq;
    private String picture;
    private String sign;
}
