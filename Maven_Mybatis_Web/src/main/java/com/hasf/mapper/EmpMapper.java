package com.hasf.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hasf.entity.Emp;

public interface EmpMapper {
	//添加数据
	@Insert(" insert into Emp(name,age,address,birthday,uid) values(#{name},#{age},#{address},#{birthday},#{uid}) ")
	//@Options 数据交换
	//useGeneratedKeys = true表示使用数据库自动增长的主键，该操作需要数据库底层支持此功能
	//keyProperty="id"  把主键的值复制给emp表的id属性
	@Options(useGeneratedKeys = true,keyProperty="id")
	int insertEmp(Emp emp);
	
	//根据id删除数据
	@Delete(" delete from emp where id = #{id} ")
	void deleteEmp(String id);
	
	//修改数据
	@Update(" update emp set name=#{name},age=#{age},address=#{address},birthday=#{birthday},uid=#{uid}  where id = #{id} ")
	int update(Emp emp);
	
	//查询单条数据
	@Select(" select * from emp where id = #{id} ")
	/*
	 * 配置返回值映射
	 * @Results  配置返回值与实体的映射
	 * @Result   配置属性与字段
	 * id=true   是主键，默认是false
	 * column="id"  表的主键是id
	 * property="id"  实体类属性是id
	 * */
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="address",property="address"),
		@Result(column="birthday",property="birthday",javaType=Date.class),
		@Result(column="uid",property="uid"),
	})
	Emp selectEmpById(int id);
	
	//查询全部数据
	@Select(" select * from emp ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="address",property="address"),
		@Result(column="birthday",property="birthday",javaType=Date.class),
		@Result(column="uid",property="uid"),
	})
	List<Emp> selectEmpAll();

}
