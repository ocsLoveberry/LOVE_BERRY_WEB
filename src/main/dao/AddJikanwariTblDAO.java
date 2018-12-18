package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class AddJikanwariTblDAO extends DAOBase{
	private Statement stmt;

	public int add_jikanwari(String class_cd, String start_date, String start_time_cd, String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String sql = "INSERT INTO JIKANWARI_TBL (CLASS_CD,START_DATE,START_TIME_CD,TOKUTEI_CD) VALUES( '" + class_cd + "' , '" + start_date + "' , '" + start_time_cd + "' , '" + tokutei_cd + "' )";
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
