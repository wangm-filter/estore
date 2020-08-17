package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements IOrderFormService{

	@Override
	public void inertOrderForm(OrderForm orderForm) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.insertOrder(orderForm);
		session.commit();
	}

	@Override
	public List<OrderForm> selectOrderByCustId(int custid) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		List<OrderForm> orderlist = mapper.selectOrderByCustId(custid);
		
		return orderlist;
	}

	@Override
	public void deleteFormById(int orderFormid) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.deleteOrderFormById(orderFormid);
		session.commit();
	}
}
