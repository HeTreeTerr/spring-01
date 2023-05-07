package com.hss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UserService {

	@Autowired
	private IndexService indexService;

	public UserService() {
		System.out.println("init UserService");
	}

	public void getService(){
		System.out.println("UserService -- getService");
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	@PostConstruct
	public void beanInit(){
		System.out.println("userService be init");
	}

	@PreDestroy
	public void beanDestroy(){
		System.out.println("userService be destroy");
	}
}
