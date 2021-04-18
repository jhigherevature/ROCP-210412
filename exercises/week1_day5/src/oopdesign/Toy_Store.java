package oopdesign;

import java.io.Serializable;
import java.util.Scanner;

public class Toy_Store implements Serializable {

	private Employee e = new Employee();
	private Shelf s = new Shelf();
	static Scanner console = new Scanner(System.in);
	
	/*
	 * I followed the guidelines, but it didn't exactly say anything about making the toy store
	 * class executable or having another class be executable and do something, so I got creative.
	 */
	
	public static void main(String[] args)
	{
		int userInput;
		
		//instantiate a Toy_Store object to get started
		Toy_Store toyStore = new Toy_Store();
		
		//Name the store's employee
		toyStore.e.setName("Bob");
		
		//Get references to the toys on the shelf of the toy store
		Toy boardGame = toyStore.s.getBoard_Game();
		Toy Doll = toyStore.s.getDoll();
		Toy RC = toyStore.s.getRadio_Controlled_Toy();
		
		//set name, price and item number
		boardGame.setItemNumer(0);
		boardGame.setName("Monopoly");
		boardGame.setPrice(14.99);
		Doll.setItemNumer(1);
		Doll.setName("Barbie");
		Doll.setPrice(7.99);
		RC.setItemNumer(2);
		RC.setName("RC Car");
		RC.setPrice(24.99);
		
		//Run shop
		System.out.println("Hello my name is " + toyStore.e.getName());
		
		do
		{
			System.out.println("Here are the toys we have today.");
			System.out.println(boardGame.getName());
			System.out.println(Doll.getName());
			System.out.println(RC.getName());
			System.out.println("To see the price and item number enter 1 for the board game, 2 for the Doll, or 3 for the RC.");
			userInput = console.nextInt();
			switch(userInput)
			{
			case 1: 
				System.out.println("Price: " + boardGame.getPrice());
				System.out.println("Item Number: " + boardGame.getItemNumber());
				break;
			case 2:
				System.out.println("Price: " + Doll.getPrice());
				System.out.println("Item Number: " + Doll.getItemNumber());
				break;
			case 3:
				System.out.println("Price: " + RC.getPrice());
				System.out.println("Item Number: " + RC.getItemNumber());
				break;
			default:
				System.out.println("Please enter a valid number");
			}
			System.out.println("Enter 1 to quit or any other number to see the price and item number of another toy");
			userInput = console.nextInt();
		}
		while(userInput != 1);
	}
	
	public Toy_Store()
	{
		super();
	}
	
	public Employee getEmployee()
	{
		return e;
	}
	
	public Shelf getShelf()
	{
		return s;
	}
	
	public void setEmployee(String name)
	{
		e.setName(name);
	}
}