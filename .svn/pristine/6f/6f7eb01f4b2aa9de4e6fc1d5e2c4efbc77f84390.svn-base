package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;
//@WebServlet("/toindexServlet")
public class ToindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICategoryService cateService = new CategoryServiceImpl();
		List<Category> categorylist = cateService.findFirstwithSecondCategory();
		request.setAttribute("categorylist", categorylist);
		
		IBookservice bookservice = new BookServiceImpl();
		List<Book> booklist = bookservice.finfBookById(1);
		request.setAttribute("booklist", booklist);
		
		List<Book> books = bookservice.seelctBooks();
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
