package com.hasf.entity;

import java.util.Date;

public class Emp {
    private Integer id;

    private String name;

    private Integer age;

    private String address;

    private Date birthday;
    
    private Integer uid;

    public Emp(Integer id, String name, Integer age, String address, Date birthday, Integer uid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.birthday = birthday;
		this.uid = uid;
	}

	public Emp(String name, Integer age, String address, Date birthday, Integer uid) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.birthday = birthday;
		this.uid = uid;
	}

	

    public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", birthday=" + birthday
				+ ", uid=" + uid + "]";
	}
    
}