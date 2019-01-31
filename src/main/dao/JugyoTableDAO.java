package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.JugyoTable;

public class JugyoTableDAO extends DAOBase implements DAOinterface {

	@Override
	public ArrayList<JugyoTable> selectAll() {
		ArrayList<JugyoTable> jugyo;
		jugyo = new ArrayList<>();
		final String sql = "SELECT * FROM JUGYO_TBL";
		ResultSet rs = null;

		this.open();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
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
				jugyo.add(new JugyoTable(
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}

		return jugyo;
	}

	private PreparedStatement pstmt;
	@Override
	public ArrayList<JugyoTable> selectWhere(String where) {
		ArrayList<JugyoTable> jugyo;
		jugyo = new ArrayList<>();
		final String sql = "SELECT * FROM JUGYO_TBL WHERE SUBJECTS_CD = ? ORDER BY START_DATE, START_TIME_CD";
		ResultSet rs = null;
		this.open();
		try {
			pstmt = con.prepareStatement(sql);
			setPstmt(pstmt,sql,where);
			System.out.println(sql);
			rs = pstmt.executeQuery();
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
				jugyo.add(new JugyoTable(
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}
		return jugyo;
	}


	private void setPstmt(PreparedStatement pstmt, String sql, String where) throws SQLException {
		pstmt.setString(1, where);
	}

	@Override
	public boolean deleteWhere(String where) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean insert() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
