package com.hss.dao.impl;

import com.hss.dao.BookDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(value = "bookDaoMysql")
@Primary
public class BookDaoMysqlImpl implements BookDao {

	@Override
	public void doSomeThings() {
		System.out.println("BookDaoMysqlImpl.doSomeThings is run");
	}
}
