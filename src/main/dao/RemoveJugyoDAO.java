package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class RemoveJugyoDAO extends DAOBase{
	private Statement stmt;

	public int delete_jugyo(String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String sql = "DELETE FROM JUGYO_TBL WHERE TOKUTEI_CD = '" + tokutei_cd + "'";
			stmt = con.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return num;
	}
}