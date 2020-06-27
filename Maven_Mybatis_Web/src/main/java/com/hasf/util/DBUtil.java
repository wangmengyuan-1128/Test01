package com.hasf.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	//获取
	public static SqlSessionFactory getSqlSessionFactory(String path){
		//获取SqlSessionFactoryBuilder加载器
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
		//获取配置文件的输入流
		InputStream inputStream = null ;
		try {
			inputStream = Resources.getResourceAsStream(path);
		} catch (IOException e) {
			System.out.println("文件路径错误");
			e.printStackTrace();
		}
		//读取配置文件
		return sqlSessionFactoryBuilder.build(inputStream);
	}

}
