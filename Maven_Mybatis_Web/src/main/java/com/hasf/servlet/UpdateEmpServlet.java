package com.hasf.servlet;

import java.io.IOException;

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

@WebServlet("/updateEmp")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateEmp");
		
		SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory("mybatis/SqlMapConfig.xml");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		String id = request.getParameter("id");
		Emp emp = empMapper.selectEmpById(Integer.parseInt(id));
		request.setAttribute("emp",emp);
		request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
