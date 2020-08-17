package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class selectBookByClick {
	@Test
	public void test1() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> selectBookByClick = mapper.selectBookByClick();
		System.out.println(selectBookByClick);
	}
	
	@Test
	public void test2() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> books = mapper.selectBooks();
		System.out.println(books);
	}
	
	@Test
	public void test3() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		List<ShopAddress> list = mapper.selectAddressByCustId(1);
		for (ShopAddress shopAddress : list) {
			System.out.println(shopAddress);
		}
	} 
	@Test
	public void test4() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		ShopAddress list = mapper.selectAddressById(1);
			System.out.println(list);
	} 
	@Test
	public void test5() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		List<OrderForm> list = mapper.selectOrderByCustId(1);
		System.out.println(list);
	} 
	@Test
	public void test6() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		List<OrderLine> list = mapper.selectOrderLineById(1);
		System.out.println(list);
	} 
	
	
}
