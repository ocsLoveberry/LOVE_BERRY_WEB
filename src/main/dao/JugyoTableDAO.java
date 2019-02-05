package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.JugyoTable;

public class JugyoTableDAO extends DAOBase implements DAOinterface {

	private static ResultSet rs;

	@Override
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

	private PreparedStatement pstmt;

	private void setPstmt(PreparedStatement pstmt, String sql, String Subjects_cd) throws SQLException {
		pstmt.setString(1, Subjects_cd);
	}
	@Override
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
			System.out.println("発行されているクエリの表示"+sql);
			rs = pstmt.executeQuery();
			System.out.println("rsに何が入っているかを表示する: "+rs);
			jugyolist = GetStringList(rs);
		System.out.println("getStringListからデータを格納できているかどうか :"+jugyolist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}
		return jugyolist;
	}




	@Override
	public boolean deleteWhere(String where) {
		return false;
	}

	@Override
	public boolean insert() {
		return false;
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

}
