package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.JikanwariData;

public class TimeTableDAO extends DAOBase {

	public ArrayList<JikanwariData> getJikanwari(){

		ArrayList<JikanwariData> jikanwariData = new ArrayList<>();
		String sql = "SELECT * FROM JIKANWARI_TBL WHERE CLASS_CD = 'R4A1System'";
		ResultSet rs = this.executeQuery(sql);
			try {
				while(rs.next()) {
					jikanwariData.add(new JikanwariData(rs.getString("TOKUTEI_CD"), rs.getString("START_DATE")));
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			this.close(stmt);

		return jikanwariData;
	}

}
