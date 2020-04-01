package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZhurnalMaper {
	public static Zhurnal map(ResultSet result) throws SQLException{
		int id_zhurnal = result.getInt("id");
		String nameZhurnal = result.getString("nameZhurnal");
		double priseZhurnal = result.getDouble("priseZhurnal");
		
		return new Zhurnal(id_zhurnal, nameZhurnal, priseZhurnal);
	}
}
