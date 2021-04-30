package javadataaccessobjects;

import bankerlogin.BankerLogin;
import bankers.Bankers;

public interface ReviewBankerInformationDAO {
	
	public void reviewBankerInformation();
	public Bankers updateBankerInformation(Integer id, Bankers b);
	public BankerLogin updateLoginInformation(Integer id, BankerLogin bl);

}
