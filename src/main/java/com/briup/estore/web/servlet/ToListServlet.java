package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.impl.BookServiceImpl;

public class ToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cateId = Integer.parseInt(request.getParameter("id"));
		
		IBookservice bookservice = new BookServiceImpl();
		List<Book> booklist = bookservice.selectBookByCateId(cateId);
		request.setAttribute("booklist", booklist);
		
		List<Book> topBooklist = bookservice.selectBookByCateIdAndClick(cateId);
		request.setAttribute("topBooklist", topBooklist);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
