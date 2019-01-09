package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Insert_LOBE_TBL_DAO extends DAOBase {
	private Statement stmt;
	public int Insert_LOBE_TBL(String newLobeName, String installation_location) throws DatabaseException, SystemException {
		String sql = "INSERT INTO LOBE_TBL (LOBE_ID, ROOM_CD) VALUES ('" + newLobeName + "', '" + installation_location +"')";
		int result = 0;
		try {
			this.open();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return result;
	}
}