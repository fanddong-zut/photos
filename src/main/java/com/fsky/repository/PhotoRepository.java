package com.fsky.repository;

import com.fsky.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by FDD on 2018/1/17.
 */
public interface PhotoRepository extends JpaRepository<Photo, String> {
    List<Photo> findAllByUserName(String userName);
}
