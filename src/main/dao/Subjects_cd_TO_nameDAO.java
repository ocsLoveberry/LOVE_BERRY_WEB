package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Subjects_cd_TO_nameDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> to_name(ArrayList<String> subjects_cd) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> subjects_name = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs;
			String sql;
			for(int i=0; i<subjects_cd.size();i++){
				sql = "select SUBJECTS_NAME from SUBJECTS_LIST_TBL where SUBJECTS_CD = '" + subjects_cd.get(i) + "'";
				rs = stmt.executeQuery(sql);
				rs.next();
				subjects_name.add(rs.getString("SUBJECTS_NAME"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return subjects_name;
	}

	public String to_name(String subjects_cd) throws DatabaseException, SystemException {
		this.open();
		String subjects_name;
		try {
			stmt = con.createStatement();
			ResultSet rs;
			String sql = "select SUBJECTS_NAME from SUBJECTS_LIST_TBL where SUBJECTS_CD = '" + subjects_cd + "'";
			rs = stmt.executeQuery(sql);
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
