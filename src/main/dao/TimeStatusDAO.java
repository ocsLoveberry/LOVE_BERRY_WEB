package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class TimeStatusDAO extends DAOBase{
	private Statement stmt;

	public void add_time_status(ArrayList<String> class_cd_List,String subjects_cd,String start_date,String start_time_cd,String year) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> seki_no_List = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs;
			String sql;
			Search_studentDAO ssDAO = new Search_studentDAO();
			for(int i=0; i<class_cd_List.size();i++){
				//クラス内のseki_noリストで取得
				seki_no_List = ssDAO.search_student(class_cd_List.get(i),year);
				for(int j=0; j<seki_no_List.size();j++){
					//クラス内の生徒の出席情報テーブル追加、ダブリとかのエラーはスルーする→ignore
					sql = ("INSERT IGNORE INTO TIME_STATUS_TBL (SEKI_NO,SUBJECTS_CD,START_DATE,START_TIME_CD) VALUES( '" + seki_no_List.get(j) + "' , '" + subjects_cd + "', '" + start_date + "' , '" + start_time_cd + "')");
					int num = stmt.executeUpdate(sql);
				}
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}

	public void delete_time_status(String subjects_cd,String start_date,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		try {
			stmt = con.createStatement();
			String sql = "DELETE FROM TIME_STATUS_TBL WHERE SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			int num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}

	public void revise_time_status(String nitiji, String jigen,String start_date,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		try {
			stmt = con.createStatement();
			String sql = "UPDATE IGNORE TIME_STATUS_TBL SET START_DATE = '" + nitiji + "', START_TIME_CD = '" + jigen + "' WHERE START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			int num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}

	public void update_temp_status(String tokutei_cd,String subjects_cd,String start_date,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		//授業の教室リスト
		ArrayList<String> room_cd_List = new ArrayList<String>();
		//各生徒の打刻情報リスト
		ArrayList<String> punch_time_List = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs;
			ResultSet rs2;
			String sql;
			String count;
			String room_cd1=null,room_cd2=null,room_cd3=null;
			sql = "SELECT ROOM_CD1,ROOM_CD2,ROOM_CD3 FROM JUGYO_TBL WHERE TOKUTEI_CD = '" + tokutei_cd + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//教室のcd取得
			while(rs.next()) {
				room_cd1 = rs.getString("ROOM_CD1");
				room_cd2= rs.getString("ROOM_CD2");
				room_cd3 = rs.getString("ROOM_CD3");
				if (room_cd1 != null) {
					room_cd_List.add(room_cd1);
				}
				if (room_cd2 != null) {
					room_cd_List.add(room_cd2);
				}
				if (room_cd3 != null) {
					room_cd_List.add(room_cd3);
				}
			}
			//カード受付時刻取得
			String start_time,end_time,late_time;
			sql = "SELECT * FROM TIME_LIST_TBL WHERE TIME_CD = '" + start_time_cd + "' ";
			rs = stmt.executeQuery(sql);
			rs.next();
			start_time = rs.getString("CARD_START_TIME");
			end_time = rs.getString("CARD_END_TIME");
			late_time = rs.getString("CARD_LATE_TIME");

			String seki_no;
			sql = "SELECT SEKI_NO FROM TIME_STATUS_TBL WHERE SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
			rs = stmt.executeQuery(sql);


			String punch_time;
			String temp_status = "9";
			while(rs.next()) {
				//特定学生、特定教室、特定日時の打刻情報取得
				seki_no = rs.getString("SEKI_NO");
				for(int i=0; i<room_cd_List.size();i++){
					sql = "SELECT TIME FROM TIME_TBL WHERE SEKI_NO = '" + seki_no +  "' AND LOBE_ID = '" + room_cd_List.get(i) + "' AND DATE = '" + start_date + "'";
					rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {
						punch_time_List.add(rs2.getString("TIME"));
					}
				}
				for(int j=0; j<punch_time_List.size();j++){
					punch_time = punch_time_List.get(j);
					System.out.println(punch_time);
					if(punch_time.compareTo(start_time)==0 || punch_time.compareTo(start_time)==1) {
						if(punch_time.compareTo(late_time)==-1 || punch_time.compareTo(late_time)==0) {
							temp_status="1";
							break;
						}else if(punch_time.compareTo(end_time)==-1 || punch_time.compareTo(end_time)==0) {
							temp_status ="3";
						}
					}else {
						if(temp_status == "9") {
							temp_status="2";
						}
					}
				}
				if(temp_status!="9") {
					sql = "UPDATE TIME_STATUS_TBL SET TEMP_STATUS = '" + temp_status + "' WHERE SEKI_NO = '" + seki_no +  "' AND SUBJECTS_CD = '" + subjects_cd + "' AND START_DATE = '" + start_date + "' AND START_TIME_CD = '" + start_time_cd + "'";
					int num = stmt.executeUpdate(sql);
				}

			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}
}
