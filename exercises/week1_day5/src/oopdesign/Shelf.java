package oopdesign;

import java.io.Serializable;

public class Shelf implements Serializable {

	private Board_Game b = new Board_Game();
	private Radio_Controlled_Toy t = new Radio_Controlled_Toy();
	private Doll d = new Doll();
	
	public Shelf()
	{
		super();
	}
	
	public Board_Game getBoard_Game()
	{
		return b;
	}
	
	public Radio_Controlled_Toy getRadio_Controlled_Toy()
	{
		return t;
	}
	
	public Doll getDoll()
	{
		return d;
	}
}