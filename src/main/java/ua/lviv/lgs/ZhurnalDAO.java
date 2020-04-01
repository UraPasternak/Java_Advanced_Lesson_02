package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZhurnalDAO {
	private static String READ_ALL = "select * from zhurnals";
	private static String CREATE = "insert into zhurnals (nameZhurnal, priseZhurnal) values (?,?)";
	private static String READ_BY_ID = "select * from zhurnals where id =?";
	private static String UPDATE_BY_ID = "update zhurnals set nameZhurnal =?, priseZhurnal =? where id =?";
	private static String DELETE_BY_ID = "delete from zhurnals where id =?";
	
	private Connection connection;
	private PreparedStatement preparedStatement; 
	
	public ZhurnalDAO(Connection connection){
		this.connection = connection;
	}
	
	public List<Zhurnal> readAll() throws SQLException{
		List<Zhurnal> listOfZhurnal = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()){
			listOfZhurnal.add(ZhurnalMaper.map(result));
		}
		
		return listOfZhurnal;
	}
	
	public void insert (Zhurnal zhurnal) throws SQLException{
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, zhurnal.getNameZhurnal());
		preparedStatement.setDouble(2, zhurnal.getPriseZhurnal());
		preparedStatement.executeUpdate();
	}
	
	public Zhurnal read(int id) throws SQLException{
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return ZhurnalMaper.map(result);
	}
	
	public void update(Zhurnal zhurnal) throws SQLException{
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, zhurnal.getNameZhurnal());
		preparedStatement.setDouble(2, zhurnal.getPriseZhurnal());
		preparedStatement.setInt(3, zhurnal.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException{
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
}
