package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService{

	@Override
	public void insertLine(OrderLine orderLine) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.insertLine(orderLine);
		session.commit();
	}

	@Override
	public List<OrderLine> selectLine(int id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		List<OrderLine> orderLinelist = mapper.selectOrderLineById(id);
		return orderLinelist;
	}

	@Override
	public void deleteOrderLineByFromId(int orderFormId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.deleteOrderLineByFromId(orderFormId);
		session.commit();
	}
}
