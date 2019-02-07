/**
 * カレンダーで使うクラス
 * 出席数を表示するためにtime_status_tblからカウントする
 *
 * @author 154139
 */

package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeStatusTableDAO extends DAOBase {
	private Statement stmt;

	public int selectCount(String seki_no, String subjects_cd) {

		int count = 0;

//		他のテーブルと突き合わせて欠席とかもださなあかん
		String sql = "SELECT COUNT(*) AS COUNT FROM TIME_STATUS_TBL WHERE SEKI_NO = " + seki_no + " AND SUBJECTS_CD = '" + subjects_cd + "'";
		this.open();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			this.close(stmt);
		}

		return count;

	}
//	public ArrayList<TimeStatusTable> selectCount() {
//
//		ArrayList<TimeStatusTable> TimeStatusList = new ArrayList<>();
//
//		String sql = "SELECT COUNT(*) AS COUNT FROM TIME_STATUS_TBL WHERE SEKI_NO = 154101";
//
//		this.open();
//		try {
//			stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				int count = rs.getInt("COUNT");
//				TimeStatusList.add(new TimeStatusTable(count));
//			}
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		return TimeStatusList;
//
//	}
}
