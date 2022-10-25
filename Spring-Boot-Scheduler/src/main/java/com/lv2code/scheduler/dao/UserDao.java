package com.lv2code.scheduler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lv2code.scheduler.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
