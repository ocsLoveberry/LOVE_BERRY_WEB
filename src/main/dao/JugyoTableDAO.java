package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.JugyoTable;
import javaBeans.TimeListTable;

public class JugyoTableDAO extends DAOBase  {

	private static ResultSet rs;
	private PreparedStatement pstmt;

	public ArrayList<JugyoTable> selectAll() {
		ArrayList<JugyoTable> jugyolist;
		jugyolist = new ArrayList<>();
		final String sql = "SELECT * FROM jugyolist_TBL";
		ResultSet rs = null;

		this.open();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			jugyolist = GetStringList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}

		return jugyolist;
	}


	private void setPstmt(PreparedStatement pstmt, String sql, String Subjects_cd) throws SQLException {
		pstmt.setString(1, Subjects_cd);
	}

	public ArrayList<JugyoTable> selectWhere(String Subjects_cd) {
		ArrayList<JugyoTable> jugyolist;
		jugyolist = new ArrayList<>();
		final String sql = "SELECT * FROM JUGYO_TBL WHERE SUBJECTS_CD = ? ORDER BY START_DATE, START_TIME_CD";
		ResultSet rs = null;
		this.open();
		try {
			pstmt = con.prepareStatement(sql);
			setPstmt(pstmt, sql, Subjects_cd);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			jugyolist = GetStringList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}
		System.out.println("jugyolistの値その２:+" + jugyolist);
		return jugyolist;
	}


	public ArrayList<JugyoTable> Jugyo_Detail(String tokutei_cd) {
		ArrayList<JugyoTable> jugyolist;
		jugyolist = new ArrayList<>();
		String sql = " SELECT * FROM JUGYO_TBL WHERE TOKUTEI_CD = ? ";
		ResultSet rs = null;
		this.open();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tokutei_cd);
		//	System.out.println("発行されているクエリの表示"+sql);
			rs = pstmt.executeQuery();
		//	System.out.println("rsに何が入っているかを表示する: "+rs);
			jugyolist = GetStringList(rs);
		//	System.out.println("getStringListからデータを格納できているかどうか :"+jugyolist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}
		return jugyolist;
	}

	public static ArrayList<JugyoTable> GetStringList(ResultSet rs) {
		ArrayList<JugyoTable> jugyolist;
		jugyolist = new ArrayList<>();
//		System.out.println("中に入ってきてますよーの表示");
		try {
			while (rs.next()) {
				String subjects_cd = rs.getString("subjects_cd");
				String start_date = rs.getString("start_date");
				String start_time_cd = rs.getString("start_time_cd");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String room_cd1 = rs.getString("room_cd1");
				String room_cd2 = rs.getString("room_cd2");
				String room_cd3 = rs.getString("room_cd3");
				String message = rs.getString("message");
				String comment = rs.getString("comment");
				String seki_no = rs.getString("seki_no");
				String tokutei_cd = rs.getString("tokutei_cd");
				jugyolist.add(new JugyoTable(
						subjects_cd,
						start_date,
						start_time_cd,
						start_time,
						end_time,
						room_cd1,
						room_cd2,
						room_cd3,
						message,
						comment,
						seki_no,
						tokutei_cd));
				System.out.println("jugyolistの値:+" + jugyolist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugyolist;
	}

	public boolean insert(String subjects_cd, String start_date, String start_time_cd, String tokutei_cd,String room_cd1,String room_cd2, String room_cd3,String comment) {
		String sql = "INSERT INTO JUGYO_TBL ("
				+ "SUBJECTS_CD, "
				+ "START_DATE, "
				+ "START_TIME_CD, "
				+ "TOKUTEI_CD, "
				+ "ROOM_CD1, "
				+ "ROOM_CD2, "
				+ "ROOM_CD3, "
				+ "START_TIME, "
				+ "END_TIME, "
				+ "CARD_START_TIME, "
				+ "CARD_END_TIME,"
				+ "COMMENT"
				+ ") VALUES ("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
				+ ")";
		System.out.println("JugyoDetaildao:142:start_time_cd"+start_time_cd);
		ArrayList<TimeListTable> TimeListTable = new ArrayList<>();
		TimeListTable.add(getTimeList(start_time_cd));

//		START_TIME, END_TIME,CARD_START_TIME,CARD_END_TIME
		ResultSet rs = null;
		int result = 0;
		try {
			this.open();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subjects_cd);
			pstmt.setString(2, start_date);
			pstmt.setString(3, start_time_cd);
			pstmt.setString(4, tokutei_cd);
			pstmt.setString(5, room_cd1);
			if(room_cd2.equals("")) {
				room_cd2 = null;
			}
			if(room_cd3.equals("")) {
				room_cd3 = null;
			}
			pstmt.setString(6, room_cd2);
			pstmt.setString(7, room_cd3);
			pstmt.setString(8, TimeListTable.get(0).getStart_time());
			pstmt.setString(9, TimeListTable.get(0).getEnd_time());
			pstmt.setString(10, TimeListTable.get(0).getCard_start_time());
			pstmt.setString(11, TimeListTable.get(0).getCard_end_time());
			pstmt.setString(12, comment);
			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(pstmt,rs);
		}
		boolean isInsertOk = false;
		if(result > 0) {
			isInsertOk = true;
		}
		return isInsertOk;
	}

	private TimeListTable getTimeList(String start_time_cd) {
		String sql = "SELECT * FROM TIME_LIST_TBL WHERE TIME_CD = '" + start_time_cd + "'";
		ResultSet rs = null;
		TimeListTable timeListTable = null;
		this.open();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			rs.next();
			String time_cd = rs.getString("time_cd");
			String start_time = rs.getString("start_time");
			String end_time = rs.getString("end_time");
			String card_start_time = rs.getString("card_start_time");
			String card_end_time = rs.getString("card_end_time");
			timeListTable = new TimeListTable(time_cd, start_time, end_time, card_start_time, card_end_time);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}

		return timeListTable;
	}

//	引数をbeansでやったほうがオブ指向っぽいじゃん
	public boolean update(JugyoTable jugyoData) {
		String sql = "UPDATE JUGYO_TBL SET "
				+ "SUBJECTS_CD = ? "
				+ ",START_DATE = ?  "
				+ ",START_TIME_CD = ? "
				+ ",TOKUTEI_CD = ? "
				+ ",ROOM_CD1 = ? "
				+ ",ROOM_CD2 = ? "
				+ ",ROOM_CD3 = ? "
				+ ",START_TIME = ? "
				+ ",END_TIME = ? "
				+ ",CARD_START_TIME = ? "
				+ ",CARD_END_TIME = ? "
				+ ",COMMENT = ? ";
		ArrayList<TimeListTable> TimeListTable = new ArrayList<>();
		TimeListTable.add(getTimeList(jugyoData.getStart_time_cd()));
		ResultSet rs = null;
		int result = 0;
		try {
			this.open();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jugyoData.getSubjects_cd());
			pstmt.setString(2, jugyoData.getStart_date());
			pstmt.setString(3, jugyoData.getStart_time_cd());
			pstmt.setString(4, jugyoData.getTokutei_cd());
			pstmt.setString(5, jugyoData.getRoom_cd1());
			if(jugyoData.getRoom_cd2().equals("")) {
				jugyoData.setRoom_cd2(null);
			}
			if(jugyoData.getRoom_cd3().equals("")) {
				jugyoData.setRoom_cd3(null);
			}
			pstmt.setString(6, jugyoData.getRoom_cd2());
			pstmt.setString(7, jugyoData.getRoom_cd3());
			pstmt.setString(8, TimeListTable.get(0).getStart_time());
			pstmt.setString(9, TimeListTable.get(0).getEnd_time());
			pstmt.setString(10, TimeListTable.get(0).getCard_start_time());
			pstmt.setString(11, TimeListTable.get(0).getCard_end_time());
			pstmt.setString(12, jugyoData.getComment());
			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(pstmt,rs);
		}
		boolean isUpdateOk = false;
		if(result > 0) {
			isUpdateOk = true;
		}
		return isUpdateOk;
	}
}

