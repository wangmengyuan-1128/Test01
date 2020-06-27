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

@WebServlet("/EmpAdd")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmpAdd");
		
		SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory("mybatis/SqlMapConfig.xml");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String birth = request.getParameter("birthday");
		String uid = request.getParameter("uid");
		
		Emp emp = new Emp();
		emp.setName(name);
		emp.setAge(Integer.parseInt(age));
		emp.setAddress(address);
		try {
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			emp.setBirthday(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		emp.setUid(Integer.parseInt(uid));
		
		empMapper.insertEmp(emp);
		
		response.sendRedirect(request.getContextPath()+"/QueryEmpAll");
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
