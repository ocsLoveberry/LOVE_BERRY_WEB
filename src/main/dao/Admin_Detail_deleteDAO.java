package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Admin_Detail_deleteDAO extends DAOBase {
	private Statement stmt;

	public void Admin_Detail_deleteDAO(String seki_no)
			throws DatabaseException, SystemException {
		this.open();
		try {
			String update_sql = "UPDATE FELICA_TBL " +
								"SET IDM1 = NULL "+
								"WHERE SEKI_NO = '" + seki_no +"'";
			stmt = con.createStatement();
			stmt.executeUpdate(update_sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}
}
