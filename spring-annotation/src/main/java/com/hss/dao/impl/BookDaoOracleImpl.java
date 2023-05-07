package com.hss.dao.impl;

import com.hss.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository(value = "bookDaoOracle")
public class BookDaoOracleImpl implements BookDao {

	@Override
	public void doSomeThings() {
		System.out.println("BookDaoOracleImpl.doSomeThings is run");
	}
}
