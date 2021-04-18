package oopdesign;

import java.io.Serializable;

public class Toy implements Serializable {

	private int itemNumber;
	private String name;
	private double price;
	
	public Toy()
	{
		super();
	}
	
	public void setItemNumer(int itemNumber)
	{
		this.itemNumber = itemNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public int getItemNumber()
	{
		return itemNumber;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
}
