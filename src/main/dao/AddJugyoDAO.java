package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class AddJugyoDAO extends DAOBase{
	private Statement stmt;

	public int insert_jugyo(String subjects_cd, String start_date, String start_time_cd, String room_cd1, String room_cd2, String room_cd3) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String tokutei_cd = subjects_cd + start_date + start_time_cd;
			String sql = "INSERT INTO JUGYO_TBL (SUBJECTS_CD,START_DATE,START_TIME_CD,ROOM_CD1,ROOM_CD2,ROOM_CD3,TOKUTEI_CD) VALUES"
					+ "( '" + subjects_cd + "' , '" + start_date + "' , '" + start_time_cd + "' , '" + room_cd1 + "' , '" + room_cd2 + "' , '" + room_cd3 + "' , '" + tokutei_cd + "')";
			//nullを'null'で渡すと文字として渡される
			sql = sql.replaceAll("'null'","null");
			stmt = con.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return num;
	}

	public int update_jugyo(String tokutei_cd, String room_cd1, String room_cd2, String room_cd3) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String sql = "UPDATE JUGYO_TBL SET ROOM_CD1 = '" + room_cd1 + "', ROOM_CD2 = '" + room_cd2 + "', ROOM_CD3 = '" + room_cd3 + "' WHERE TOKUTEI_CD = '" + tokutei_cd + "'";
			//nullを'null'で渡すと文字として渡される
			sql = sql.replaceAll("'null'","null");
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
