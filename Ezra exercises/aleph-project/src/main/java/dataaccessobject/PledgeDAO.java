package dataaccessobject;

import java.util.List;

import model.Pledge;

public interface PledgeDAO {
	public boolean insertIntoPledge(Pledge pledge);
	public boolean deletePledge(Pledge pledge);
	public List<Pledge> selectPledgesByYear(Integer account, Integer year);
	public boolean updatePledge(Pledge pledge);

}
