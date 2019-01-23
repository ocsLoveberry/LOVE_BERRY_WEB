package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class SearchTokutei_cdDAO extends DAOBase{
	private Statement stmt;

	public int serch_tokutei_cd(String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		int count = 0;
		try {
			String sql = "select * from JUGYO_TBL where TOKUTEI_CD = '" + tokutei_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				count = 1;
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return count;
	}
	public ArrayList<String> to_room_cd(String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> room_cd = new ArrayList<String>();
		try {
			String sql = "select * from JUGYO_TBL where TOKUTEI_CD = '" + tokutei_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			room_cd.add(rs.getString("ROOM_CD1"));
			room_cd.add(rs.getString("ROOM_CD2"));
			room_cd.add(rs.getString("ROOM_CD3"));
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return room_cd;
	}

}
