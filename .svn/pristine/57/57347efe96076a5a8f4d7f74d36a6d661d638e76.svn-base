package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.impl.BookServiceImpl;

public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		if (id != null && num != null) {
			IBookservice bookservice = new BookServiceImpl();
			Book book = bookservice.selectBookById(Integer.parseInt(id));
			
			OrderLine line = new OrderLine();
			line.setBook(book);
			line.setNum(Integer.parseInt(num));
			line.setCost(book.getPrice() * line.getNum());
			
			HttpSession session = request.getSession();
			ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
			if (shopCar != null) {
				shopCar.addShopCar(line);
			}
		}
		request.getRequestDispatcher("/WEB-INF/user/shopCar.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
