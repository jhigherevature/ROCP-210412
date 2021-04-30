package postgredataaccessobjects;

import java.util.List;

import bankerlogin.BankerLogin;

public interface BankerLoginDAO {
	
	public boolean insertIntoBankerLogin();
	public BankerLogin selectBankerLogin(Integer id);
	public List<BankerLogin> selectAllBankerLogin();
	public BankerLogin updateUsername(Integer id, BankerLogin bl);
	public BankerLogin updatePassword(Integer id, BankerLogin bl);

}
