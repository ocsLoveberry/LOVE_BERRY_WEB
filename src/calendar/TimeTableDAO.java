/**
 * カレンダー用クラス
 * seki_noを受け取ってその生徒（教員）の時間割のデータをCalendarViewに渡す
 *
 * @author 154139
 */

package calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.JikanwariData;
import main.dao.DAOBase;

public class TimeTableDAO extends DAOBase {

	public ArrayList<JikanwariData> getJikanwari(String seki_no) {

		ArrayList<JikanwariData> jikanwariData = new ArrayList<>();
		String class_cd = getClassCd(seki_no);
		String TOKUTEI_CD = null;
		String SUBJECTS_CD = null;
		String SUBJECTS_NAME = null;
		String START_DATE = null;
		//		TODO:START_TIME_CDをIDにして渡すか検討
		String START_TIME_CD = null;
		String END = null;
		String sql = "SELECT * FROM JIKANWARI_TBL as jikanwari JOIN JUGYO_TBL as jugyo ON jikanwari.TOKUTEI_CD = jugyo.TOKUTEI_CD JOIN SUBJECTS_LIST_TBL as subject ON subject.SUBJECTS_CD = jugyo.SUBJECTS_CD WHERE jikanwari.CLASS_CD = '" + class_cd + "' ORDER BY jikanwari.START_DATE, jikanwari.START_TIME_CD";
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				TOKUTEI_CD = rs.getString("jikanwari.TOKUTEI_CD");
				SUBJECTS_CD = rs.getString("jugyo.SUBJECTS_CD");
				SUBJECTS_NAME = rs.getString("subject.SUBJECTS_NAME");
				switch (Integer.parseInt(rs.getString("jikanwari.START_TIME_CD"))) {
				case 1:
					//						TODO:このT09:15:00とかT10:45:00をデータベースから取得すべきかどうかを考える
					//						TIME_LIST_TBLを参照する
					//						取得するなら毎回参照しにいくのは処理効率が悪いのでシングルトンで実装する
					START_DATE = rs.getString("jikanwari.START_DATE") + "T09:15:00";
					END = rs.getString("START_DATE") + "T10:45:00";
					break;
				case 2:
					START_DATE = rs.getString("jikanwari.START_DATE") + "T11:00:00";
					END = rs.getString("jikanwari.START_DATE") + "T12:30:00";
					break;
				case 3:
					START_DATE = rs.getString("jikanwari.START_DATE") + "T13:30:00";
					END = rs.getString("jikanwari.START_DATE") + "T15:00:00";
					break;
				}

				jikanwariData.add(new JikanwariData(TOKUTEI_CD, SUBJECTS_NAME, START_DATE, END));
				//					System.out.println(rs.getString("TOKUTEI_CD"));
				//					System.out.println(rs.getString("START_DATE"));
				//					System.out.println(rs.getString("START_TIME_CD"));
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return jikanwariData;
	}

	public String getClassCd(String seki_no) {
		String sql = "SELECT CLASS_CD FROM OCS_JOHO_TBL WHERE SEKI_NO = '" + seki_no + "'";
		ResultSet rs = this.executeQuery(sql);
		String class_cd = null;
		try {
			while (rs.next()) {
				class_cd = rs.getString("CLASS_CD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return class_cd;
	}

}
