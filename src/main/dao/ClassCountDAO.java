package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class ClassCountDAO extends DAOBase{
	private Statement stmt;

	public String counts(String seki_no) throws DatabaseException, SystemException {
		this.open();
		String count="0";
		try {
			String sql = "select COUNT(*) as cnt from TANNIN_CLASS_TBL where SEKI_NO = '" + seki_no + "'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next());
			count =rs.getString("cnt");
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return count;
	}
}
