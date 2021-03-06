package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SerchClassSubjcetsDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> serch_subjects(String class_cd,String year) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> subjects = new ArrayList<String>();
		try {
			String sql = "select SUBJECTS_CD from CLASS_SUBJECTS_TBL where YEAR = '" + year + "' AND CLASS_CD = '" + class_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subjects.add(rs.getString("SUBJECTS_CD"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return subjects;
	}
}
