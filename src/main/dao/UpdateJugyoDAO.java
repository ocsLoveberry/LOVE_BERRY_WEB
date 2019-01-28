package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class UpdateJugyoDAO extends DAOBase{
	private Statement stmt;

	public String update_jugyo(String subjects_cd, String start_date, String start_time_cd, String room_cd1, String room_cd2, String room_cd3, String change_flag, String tokutei_cd) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String tokutei_cd_x = tokutei_cd;
			String sql = "";
			stmt = con.createStatement();
			//特定コード変更時
			if(change_flag.equals("1")) {
				tokutei_cd = subjects_cd + start_date + start_time_cd;
				sql = "UPDATE JIKANWARI_TBL SET START_DATE = '" + start_date + "', START_TIME_CD = '" + start_time_cd + "' WHERE TOKUTEI_CD = '" + tokutei_cd_x + "'";
				num = stmt.executeUpdate(sql);
			}
			sql = "UPDATE JUGYO_TBL SET START_DATE = '" + start_date + "', START_TIME_CD = '" + start_time_cd + "', ROOM_CD1 = '" + room_cd1 + "', ROOM_CD2 = '" + room_cd2 + "', ROOM_CD3 = '" + room_cd3 + "', TOKUTEI_CD = '" + tokutei_cd + "'"
					+ "WHERE TOKUTEI_CD = '" + tokutei_cd_x + "'";
			sql = sql.replaceAll("'null'","null");
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return tokutei_cd;
	}
}
