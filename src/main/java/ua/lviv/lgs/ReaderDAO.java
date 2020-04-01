package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAO {
	private static String READ_ALL = "select * from readers";
	private static String CREATE = "insert into readers (nameReader, agReader, email) values (?,?,?)";
	private static String READ_BY_ID = "select * from readers where id =?";
	private static String UPDATE_BY_ID = "update readers set nameReader =?, agReader =?, email =? where id =?";
	private static String DELETE_BY_ID = "delete from readers where id =?";
	
	private Connection connection;
	private PreparedStatement preparedStatement; 
	
	public ReaderDAO(Connection connection){
		this.connection = connection;
	}
	
	public List<Reader> readAll() throws SQLException{
		List<Reader> listOfReader = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()){
			listOfReader.add(ReaderMaper.map(result));
		}
		
		return listOfReader;
	}
	
	public void insert (Reader reader) throws SQLException{
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, reader.getNameReader());
		preparedStatement.setInt(2, reader.getAgReader());
		preparedStatement.setString(3, reader.getEmail());
		preparedStatement.executeUpdate();
	}
	
	public Reader read(int id) throws SQLException{
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return ReaderMaper.map(result);
	}
	
	public void update(Reader reader) throws SQLException{
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, reader.getNameReader());
		preparedStatement.setInt(2, reader.getAgReader());
		preparedStatement.setString(3, reader.getEmail());
		preparedStatement.setInt(4, reader.getId());
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException{
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
}
