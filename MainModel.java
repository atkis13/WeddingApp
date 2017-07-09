package application;

import java.sql.*;

public class MainModel {
	Connection conection;
	public MainModel() {
		conection = SQLiteConnection.Connector();
		if (conection == null) System.exit(1);
	}
	
	public void insertSum(String name, int sum) throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String query = "Insert into Income (Name, Sum) values (?, ?)";
		try {
			prepareStatement = conection.prepareStatement(query);
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, sum);
			prepareStatement.execute();
			//resultSet = prepareStatement.executeQuery();
			prepareStatement.close();
			
			
		} catch (Exception e) {
			
		}finally {
			
			resultSet.close();
			
		}
	}
	
	public int getSum(){
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int sum = 0;
		String query = "SELECT SUM(sum) FROM Income";
		try {
			prepareStatement = conection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
			      int c = resultSet.getInt(1);
			      sum = sum + c;
			    }
			
		}
		catch(Exception e){
			
		}
		return sum;
	}

}
