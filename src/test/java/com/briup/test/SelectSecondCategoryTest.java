package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class SelectSecondCategoryTest {
	@Test
	public void select() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		System.out.println(session);
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		List<Category> selectSecondCategory = mapper.selectFirstCategory();
		System.out.println(selectSecondCategory);
		
	}
}
