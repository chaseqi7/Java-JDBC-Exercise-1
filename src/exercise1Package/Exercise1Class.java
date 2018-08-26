package exercise1Package;
import java.sql.*;

public class Exercise1Class {
	private static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/CanadaCensusDB;create=true;traceFile=chase.txt;traceLevel=7";
	private static final int CONNECTION_FAILURE_ERROR_CODE = 0 ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(java.sql.Connection tempConnection = DriverManager.getConnection(CONNECTION_STRING);)
		{
			tempConnection.setAutoCommit (false);
			Statement tempStatement = tempConnection.createStatement();

			tempStatement.executeUpdate("CREATE TABLE HOUSEHOLDEARNERS(householdEarnersID INT NOT NULL PRIMARY KEY,description VARCHAR(50) NOT NULL)");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (1, 'Total - Number of earners in the household')");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (2, 'No earners')");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (3, '1 earner or more')");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (4, '1 earner')");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (5, '2 earners')");
			tempStatement.executeUpdate("INSERT INTO HOUSEHOLDEARNERS VALUES (6, '3 or more earners')");
			
			String tempSQLSelectQuery = "SELECT * FROM HOUSEHOLDEARNERS";
			ResultSet tempResultSet = tempStatement.executeQuery(tempSQLSelectQuery);
			
			while(tempResultSet.next()){
				System.out.println("ID:"+tempResultSet.getString("householdEarnersID")+" Description:"+tempResultSet.getString("description"));
			}
			
			tempConnection.rollback();
			tempConnection.commit();
			tempConnection.close();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			System.exit(CONNECTION_FAILURE_ERROR_CODE);
		}
	}

}

