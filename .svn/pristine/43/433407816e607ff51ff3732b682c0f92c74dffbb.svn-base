package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String name = request.getParameter("name");
		//获取密码
		String password = request.getParameter("password");
		ICustomerService customerService = new CustomerServiceImpl();
		String url = "";
		try {
			Customer customer = customerService.login(name,password);
			
			ShopCar shopCar = new ShopCar();
			
			HttpSession session = request.getSession();
			session.setAttribute("customer",customer);
			session.setAttribute("shopCar", shopCar);
			url = "toindexServlet";
		} catch (Exception e) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "用户名或密码错误!!!");
			url = "toLoginServlet";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
