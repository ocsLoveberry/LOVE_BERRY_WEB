package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class ConfirmStatusDAO extends DAOBase {
	private Statement stmt;

	public int update_status(String seki_no,String subjects_cd,String start_date,String start_time_cd,String status) throws DatabaseException, SystemException {
		int result = 0;
		try {
			this.open();
			stmt = con.createStatement();
			//まず、出席情報テーブル自体が存在するか確認
			String select_sql = "SELECT * FROM TIME_STATUS_TBL WHERE SEKI_NO = '"+ seki_no +"' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "'AND START_TIME_CD = '" + start_time_cd + "'";
			ResultSet rs = stmt.executeQuery(select_sql);
			if(!rs.next()) {
				//出席情報テーブル存在しない。→出席情報テーブル追加
				String insert_sql = "INSERT INTO TIME_STATUS_TBL (SEKI_NO, SUBJECTS_CD, START_DATE, START_TIME_CD) VALUES('" + seki_no + "', '" + subjects_cd +"', '" + start_date +"', '" + start_time_cd +"')";
				stmt.executeUpdate(insert_sql);
			}
			String update_sql = "UPDATE TIME_STATUS_TBL SET STATUS = '" + status + "' WHERE SEKI_NO = '"+ seki_no +"' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "'AND START_TIME_CD = '" + start_time_cd + "'";
			result = stmt.executeUpdate(update_sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return result;
	}
}