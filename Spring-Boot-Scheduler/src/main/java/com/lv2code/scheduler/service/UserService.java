package com.lv2code.scheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lv2code.scheduler.dao.UserDao;
import com.lv2code.scheduler.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// schedule a job to add object in DB (Every 5 sec)
	@Scheduled(fixedRate = 5000)
	public void add2DBJob() {
		User user = new User();
		user.setName("user"+new Random().nextInt(374483));
		userDao.save(user);
		
		System.out.println("Add Service call in " + new Date().toString());
	}
	
	@Scheduled(cron="0/15 * * * * *")
	public void fetchFromDBJob() {
		List<User> users = userDao.findAll();
		
		System.out.println("Fetch Service call in " + new Date().toString());
		System.out.println("no of record fetched : " + users.size());
		log.info("Users : {}", users);
	}
}
