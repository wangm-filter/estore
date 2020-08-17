package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderLineServiceImpl;

public class ToOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderFormId = request.getParameter("orderFormId");
		IOrderLineService lineService = new OrderLineServiceImpl();
		List<OrderLine> linelist = lineService.selectLine(Integer.parseInt(orderFormId));
		HttpSession session = request.getSession();
		session.setAttribute("linelist", linelist);
		int sumCost = 0;
		for (OrderLine orderLine : linelist) {
			sumCost += orderLine.getCost();
		}
		session.setAttribute("sumCost", sumCost);
		request.getRequestDispatcher("/WEB-INF/user/orderDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
