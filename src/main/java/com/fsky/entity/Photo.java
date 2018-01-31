package com.fsky.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by FDD on 2018/1/17.
 */
@Entity(name="photo")
public class Photo {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    private String userName;
    private String fileName;
    private String upDate;
    private String photoTag;//图片标签
    private String photoDescribe;//图片描述

    public Photo() {
    }

    public Photo(String userName, String fileName, String upDate,String  photoTag, String photoDescribe) {
        this.userName = userName;
        this.fileName = fileName;
        this.upDate = upDate;
        this.photoTag = photoTag;
        this.photoDescribe = photoDescribe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getPhotoTag() {
        return photoTag;
    }

    public void setPhotoTag(String photoTag) {
        this.photoTag = photoTag;
    }

    public String getPhotoDescribe() {
        return photoDescribe;
    }

    public void setPhotoDescribe(String photoDescribe) {
        this.photoDescribe = photoDescribe;
    }
}
