package dataaccessobject;

import java.util.List;

import model.Donor;

public interface DonorDAO {
	public boolean insertIntoDonors(Donor donor);
	public Donor selectDonor(Integer id);
	public List<Donor> selectAllDonors();
	public boolean updateDonor(Donor donor);
	public boolean deleteDonor(Donor donor);
	public Donor selectDonorByLoginId(Integer id);
	public Donor selectDonorByid_userpass(Integer id);
}
