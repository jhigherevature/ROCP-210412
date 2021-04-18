package oopdesign;

import java.io.Serializable;

public class Employee implements Serializable {

	private String name;
	
	public Employee()
	{
		super();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String  getName()
	{
		return name;
	}
}