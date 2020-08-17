package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;

public class ToDeleteOrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("shopAddId");
		IOrderLineService lineService = new OrderLineServiceImpl();
		lineService.deleteOrderLineByFromId(Integer.parseInt(id));
		IOrderFormService formService = new OrderFormServiceImpl();
		formService.deleteFormById(Integer.parseInt(id));
		HttpSession session = request.getSession();
		//设置弹框信息
		session.setAttribute("isDelete", "确认删除此订单吗？");
		
		request.getRequestDispatcher("/user/toOrderListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
