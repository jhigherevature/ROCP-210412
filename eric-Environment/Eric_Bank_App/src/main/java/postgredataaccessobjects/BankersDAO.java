package postgredataaccessobjects;

import java.util.List;

import bankers.Bankers;

/*
 * DAO stands for 'Data Access Object'.
 * 
 * DAO is a design patterns which models the structure of
 * our DB and provides implementation on classes which
 * implement the methods defined in a DAO Interface class.
 * This structure allows for re-usable code across different
 * database languages/types
 */

public interface BankersDAO {

	/*
	 * The DAO methods should, as a base, provide the basic
	 * CRUD operations... (note, if you need more complex code
	 * or interaction with your database, those are really just
	 * higher-level or more complex uses of these basic operations
	 */
	
	//to manipulate banker data
	public boolean insertIntoBankers();
	public Bankers selectBanker(Integer id);
	public List<Bankers> selectAllBankers();
	public Bankers updateBankerFirstName(Integer id, Bankers b);
	public Bankers updateBankerLastName(Integer id, Bankers b);
	public Bankers updateBankerJob(Integer id, Bankers b);
	public Bankers updateBankerSalary(Integer id, Bankers b);
	public boolean deleteBanker();
	
}
