package com.hasf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hasf.mapper.EmpMapper;
import com.hasf.util.DBUtil;

@WebServlet("/deleteEmp")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteEmp");
		
		SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory("mybatis/SqlMapConfig.xml");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		String id = request.getParameter("id");
		empMapper.deleteEmp(id);
		response.sendRedirect(request.getContextPath()+"/QueryEmpAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
