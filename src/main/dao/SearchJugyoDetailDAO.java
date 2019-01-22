package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SearchJugyoDetailDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> serch_jugyo(String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> jugyo_detail = new ArrayList<String>();
		try {
			String sql = "select * from JUGYO_TBL where TOKUTEI_CD = '" + tokutei_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jugyo_detail.add(rs.getString("SUBJECTS_CD"));
				jugyo_detail.add(rs.getString("START_DATE"));
				jugyo_detail.add(rs.getString("START_TIME_CD"));
				jugyo_detail.add(rs.getString("ROOM_CD1"));
				jugyo_detail.add(rs.getString("ROOM_CD2"));
				jugyo_detail.add(rs.getString("ROOM_CD3"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return jugyo_detail;
	}
}
