package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.FelicaData;

public class FelicaTableDAO extends DAOBase {
	public ArrayList<FelicaData> selectAllFelicaTable() {
		ArrayList<FelicaData> felicaData = new ArrayList<>();
		String sql = "SELECT * FROM FELICA_TBL";
		try {
			ResultSet rs = executeQuery(sql);
			while(rs.next()) {
				felicaData.add(new FelicaData(rs.getString("SEKI_NO"), rs.getString("IDM1"), rs.getString("IDM2"), rs.getString("COMMENT1"), rs.getString("COMMENT2")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return felicaData;
	}
}
