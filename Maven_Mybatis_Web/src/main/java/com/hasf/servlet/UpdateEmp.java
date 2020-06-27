package com.hasf.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hasf.entity.Emp;
import com.hasf.mapper.EmpMapper;
import com.hasf.util.DBUtil;

@WebServlet("/update")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update");
		
		SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory("mybatis/SqlMapConfig.xml");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String birth = request.getParameter("birthday");
		Date birthday=null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uid = request.getParameter("uid");
		Emp emp = new Emp(Integer.parseInt(id),name,Integer.parseInt(age),address,birthday,Integer.parseInt(uid));
		empMapper.update(emp);
		response.sendRedirect(request.getContextPath()+"/QueryEmpAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
