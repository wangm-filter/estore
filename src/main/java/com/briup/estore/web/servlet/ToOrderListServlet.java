package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;
import com.briup.estore.service.impl.ShopAddressServiceImpl;

public class ToOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据id查询地址信息
		HttpSession session = request.getSession();
		//从session中获取购物车信息
		ShopCar car = (ShopCar) session.getAttribute("shopCar");
		Customer customer = (Customer) session.getAttribute("customer");
		String addId = request.getParameter("shopAddId");
		IShopAddressService addressService = new ShopAddressServiceImpl();
		ShopAddress shopAddress = addressService.selectAddressById(Integer.parseInt(addId));
		//保存订单
		OrderForm orderForm = new OrderForm();
		orderForm.setCost(car.getCost());
		orderForm.setCustomer(customer);
		orderForm.setOrderdate(new Date());
		orderForm.setShopAddress(shopAddress);
		//保存订单项
		IOrderFormService orderFormService = new OrderFormServiceImpl();
		orderFormService.inertOrderForm(orderForm);
		
		Map<Integer, OrderLine> map = car.getOrderLines();
		Set<Entry<Integer,OrderLine>> entrySet = map.entrySet();
		IOrderLineService lineService = new OrderLineServiceImpl();
		
		for (Entry<Integer, OrderLine> entry : entrySet) {
			OrderLine line = entry.getValue();
			line.setOrderForm(orderForm);
			lineService.insertLine(line);
		}
		//查询所有订单的信息
		List<OrderForm> orderlist = orderFormService.selectOrderByCustId(customer.getId());
		request.setAttribute("orderlist", orderlist);
		System.out.println(orderlist);
		//跳转到orderList.jsp
		request.getRequestDispatcher("/WEB-INF/user/OrderList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
