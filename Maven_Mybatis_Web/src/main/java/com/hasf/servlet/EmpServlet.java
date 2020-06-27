package com.hasf.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/QueryEmpAll")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmpServlet");
		
		SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory("mybatis/SqlMapConfig.xml");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		List<Emp> empList = null;
		empList = empMapper.selectEmpAll();
		
		
		request.setAttribute("empList",empList);
		for (Emp emp : empList) {
			System.out.println(emp);
		}
		request.getRequestDispatcher("list.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
