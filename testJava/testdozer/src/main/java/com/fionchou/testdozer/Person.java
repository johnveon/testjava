package com.fionchou.testdozer;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Person
{
	private String id;
	
	private Integer age;
	
	private Boolean marry;
	
	private Map children;
	
	private List<Person> childs;

	public List<Person> getChilds()
	{
		return childs;
	}

	public void setChilds(List<Person> childs)
	{
		this.childs = childs;
	}

	public Map getChildren()
	{
		return children;
	}

	public void setChildren(Map children)
	{
		this.children = children;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Boolean getMarry()
	{
		return marry;
	}

	public void setMarry(Boolean marry)
	{
		this.marry = marry;
	}

}
