package dataaccessobject;

import java.util.List;

import model.School;

public interface SchoolDAO {
	public boolean insertIntoSchool(School school);
	public School selectSchool(Integer id);
	public List<School> selectAllSchools();
	public boolean updateSchool(School school);
	public boolean deleteSchool(School school);
}
