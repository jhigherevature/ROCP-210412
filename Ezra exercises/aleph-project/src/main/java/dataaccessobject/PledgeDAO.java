package dataaccessobject;

import java.util.List;

import model.Pledge;

public interface PledgeDAO {
	public boolean insertIntoPledge(Pledge pledge);
	public boolean deletePledge(Pledge pledge);
	public List<Pledge> selectPledgesByYear(Integer account, Integer year);
	public List<Pledge> selectPledgesByYear(Integer year);
	public boolean updatePledge(Pledge pledge);
	int getPledgeNumber(Integer account_id, int pledge_year);
	Double getPledgeValue(Integer account_id, int pledge_year);
	Double getPledgeValueAll(int pledge_year);
	int getPledgeNumberAll(int pledge_year);
	boolean deletePledge(Integer pledge_id);
	boolean deletePledge(Pledge pledge, Integer account_id);
	Pledge selectPledge(Integer id);
	List<Pledge> selectPledges(Integer id_pledge);
	Pledge selectPledgebyDonor(Integer id);

}
