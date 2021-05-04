package dao;

import java.util.List;
import model.UserAccount;

public interface UserAccountInterface {
    public boolean insertIntoUsers(UserAccount user);

    public UserAccount selectUser(String email);

    public List<UserAccount> selectAllUsers();

    public boolean updateUser(UserAccount user);

    public boolean deleteUser(UserAccount user);

    public UserAccount selectUserByUid(Integer uid);
}
