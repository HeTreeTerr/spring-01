package com.hss.domain;

import com.hss.anntation.LogAnnotation;

/**
 * 工人
 */
@LogAnnotation(desc = "jojo")
public class Worker {

	private Long id;

	private String name;

	public Worker() {
	}

	public Worker(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
