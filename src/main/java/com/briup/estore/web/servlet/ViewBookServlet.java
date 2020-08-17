package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.impl.BookServiceImpl;

public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookservice iBookservice = new BookServiceImpl();
		String id = request.getParameter("id");
		//根据id查询书籍
		Book book = iBookservice.selectBookById(Integer.parseInt(id));
		//将查出的书籍保存到request中
		request.setAttribute("book", book);
		//跳转到viewbook.jsp页面
		request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
