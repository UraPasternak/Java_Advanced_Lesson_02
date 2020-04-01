package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderMaper {
	
	public static Reader map(ResultSet result) throws SQLException{
		int id_reader = result.getInt("id");
		String nameReader = result.getString("nameReader");
		int agReader = result.getInt("agReader");
		String email = result.getString("email");
		
		return new Reader(id_reader, nameReader,agReader,email);
	}
}
