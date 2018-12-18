package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SetTimeContentDAO extends DAOBase{
	private Statement stmt;

	public void set_timecontent(String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String sql = "UPDATE JUGYO_TBL J INNER JOIN TIME_LIST_TBL T ON J.START_TIME_CD=T.TIME_CD "
					+ "SET J.START_TIME=T.START_TIME, J.END_TIME=T.END_TIME, J.CARD_START_TIME=T.CARD_START_TIME, J.CARD_END_TIME=T.CARD_END_TIME "
					+ "WHERE J.TOKUTEI_CD = '" + tokutei_cd + "'";
			stmt = con.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

	}
}