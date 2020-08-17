package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void register(Customer customer) throws Exception {
		
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> name = mapper.selectCustomerByName(customer.getName());
		if (name.size() > 0) {
			throw new Exception("该用户名已被使用，请重新输入!");
		}else {
			mapper.insertCustomer(customer);
			session.commit();
		}
	}

	@Override
	public Customer login(String name,String passworsd) throws Exception {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> list = mapper.selectCustomerByName(name);
		Customer customer = null;
		if (list.size() > 0) {
			customer = list.get(0);
			if (customer.getPassword().equals(passworsd)) {
				return customer;
			}else {
				throw new Exception("密码错误,请重新输入!!");
			}
		}else {
			throw new Exception("用户名不存在,请重新输入!!");
		}
	}
}
