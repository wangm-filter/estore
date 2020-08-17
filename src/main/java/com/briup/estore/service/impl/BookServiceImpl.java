package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.service.IBookservice;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookservice {

	@Override
	public List<Book> finfBookById(int id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByClick();

		return booklist;
	}

	@Override
	public List<Book> seelctBooks() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> allbooks = mapper.selectBooks();
		return allbooks;
	}

	@Override
	public Book selectBookById(int id) {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.selectBookById(id);
		int click = book.getClick();
		book.setClick(click + 1);
		try {
			mapper.updateBook(book);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return book;
	}

	@Override
	public List<Book> selectBookByCateId(int cateId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateId(cateId);
		
		return booklist;
	}

	@Override
	public List<Book> selectBookByCateIdAndClick(int cateId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateIdAndClick(cateId);
		
		return booklist;
	}
}
