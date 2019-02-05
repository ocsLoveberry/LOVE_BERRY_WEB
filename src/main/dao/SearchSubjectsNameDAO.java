package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SearchSubjectsNameDAO extends DAOBase{
	private Statement stmt;

	public String search_subjects_name(String subjects_cd) throws DatabaseException, SystemException {
		this.open();
		String subjects_name;
		try {
			String sql = "select * from SUBJECTS_LIST_TBL where SUBJECTS_CD = '" + subjects_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			subjects_name = rs.getString("SUBJECTS_NAME");
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return subjects_name;
	}

}
