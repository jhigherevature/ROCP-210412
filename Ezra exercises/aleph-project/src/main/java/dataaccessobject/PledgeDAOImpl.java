package dataaccessobject;

import java.sql.Connection;

import connectutil.ConnectUtil;
import model.Pledge;

public class PledgeDAOImpl {

	public boolean insertIntoPledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO ";
			ps = conn.prepareStatement(query);
			
		}
	}
}
//					rs.getDate(query)   take in as a long or String

