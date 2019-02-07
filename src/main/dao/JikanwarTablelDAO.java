/**
 * カレンダー用クラス
 * 学生用
 *
 * 時間割から全件取得するためのプログラム
 * timeTableDAoに仕様変更
 *
 * 未使用！！！！
 *
 */

package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.JikanwariTable;

public class JikanwarTablelDAO extends DAOBase {

	public ArrayList<JikanwariTable> selectAll() {
			ArrayList<JikanwariTable> jikanwari;
			jikanwari = new ArrayList<>();
			final String sql = "SELECT * FROM JIKANWARI_TBL";
			ResultSet rs = null;

			try {
				this.open();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String class_cd = rs.getString("class_cd");
					String start_date = rs.getString("start_date");
					String start_time_cd = rs.getString("start_time_cd");
					String tokutei_cd = rs.getString("tokutei_cd");
					jikanwari.add(new JikanwariTable(class_cd,start_date,start_time_cd,tokutei_cd));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return jikanwari;
	}

	public boolean insert(String class_cd, String start_date, String start_time_cd,String tokutei_cd) {
		String sql = "INSERT INTO JIKANWARI_TBL (CLASS_CD, START_DATE, START_TIME_CD, TOKUTEI_CD) VALUES (?,?,?,?)";
		ResultSet rs = null;
		int result = 0;
		try {
			this.open();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_cd);
			pstmt.setString(2, start_date);
			pstmt.setString(3, start_time_cd);
			pstmt.setString(4, tokutei_cd);
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




}
