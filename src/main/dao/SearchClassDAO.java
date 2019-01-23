package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SearchClassDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> serch_class(String subjects_cd,String year) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> class_cd_LIST = new ArrayList<String>();
		try {
			String sql = "select CLASS_CD from CLASS_SUBJECTS_TBL where YEAR = '" + year + "' AND SUBJECTS_CD = '" + subjects_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				class_cd_LIST.add(rs.getString("CLASS_CD"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return class_cd_LIST;
	}
}
