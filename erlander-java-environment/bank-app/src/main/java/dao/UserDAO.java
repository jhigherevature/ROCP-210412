package dao;

import model.User;

public interface UserDAO {
	public User selectUserByUsernameAndPassword(String username, String user_pass);
	public boolean checkIfUsernameExists(String username);
	public boolean checkIfPasswordIsCorrect(String username, String user_pass);
	public User createNewUser(User user);
}
