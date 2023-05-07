package com.hss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class IndexService {

	@Autowired
	private UserService userService;

	public IndexService() {
		System.out.println("init IndexService");
	}

	public void getService(){
		System.out.println("IndexService -- getService");
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostConstruct
	public void beanInit(){
		System.out.println("indexService be init");
	}

	@PreDestroy
	public void beanDestroy(){
		System.out.println("indexService be destroy");
	}
}
