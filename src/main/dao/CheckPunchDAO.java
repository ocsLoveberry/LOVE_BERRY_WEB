package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class CheckPunchDAO extends DAOBase{
	private Statement stmt;

	public String[] check_punch(String seki_no, String subjects_cd, String start_date ,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		String status[] = new String[2];
		//tempかconfirmどうか、nothingならデータなし
		status[0] = "";
		status[1] = "";
		try {
			String sql = "select * from TIME_STATUS_TBL where SEKI_NO = '" + seki_no + "' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("STATUS") != null) {
					status[0] = "confirm";
					status[1] = rs.getString("STATUS");
				}else if(rs.getString("TEMP_STATUS") != null){
					status[0] = "temp";
					status[1] = rs.getString("TEMP_STATUS");
				}else {
					status[0] = "nothing";
				}
			}else {
				//出席情報テーブルが無いとき
				status[0] = "nothing";
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return status;
	}

	public String check_temp_status(String seki_no, String subjects_cd, String start_date ,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		String temp_status = "";
		try {
			String sql = "select * from TIME_STATUS_TBL where SEKI_NO = '" + seki_no + "' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("TEMP_STATUS") != null) {
					temp_status = rs.getString("TEMP_STATUS");
					//1: 出席 2:欠席 3:遅刻 空欄:欠席
					if(temp_status.equals("1")) {
						temp_status = "◯";
					}else if(temp_status.equals("2")) {
						temp_status = "☓";
					}else if(temp_status.equals("3")) {
						temp_status = "△";
					}else {
						temp_status = "☓";
					}
				}else {
					temp_status = "☓";
				}
			}else {
				//出席情報テーブルが無いとき
				temp_status = "☓";
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return temp_status;
	}

	public String check_status(String seki_no, String subjects_cd, String start_date ,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		String status = "";
		try {
			String sql = "select * from TIME_STATUS_TBL where SEKI_NO = '" + seki_no + "' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("STATUS") != null) {
					status = rs.getString("STATUS");
					//1: 出席 2:欠席 3:遅刻 空欄:欠席
					if(status.equals("1")){
						status = "◯";
					}else if(status.equals("2")) {
						status = "☓";
					}else if(status.equals("3")) {
						status = "△";
					}else {
						status = "☓";
					}
				}else {
					status = "☓";
				}
			}else {
				//出席情報テーブルが無いとき
				status = "☓";
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return status;
	}
}
