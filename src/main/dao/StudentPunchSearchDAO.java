package main.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.exception.DatabaseException;
import main.exception.SystemException;

public class StudentPunchSearchDAO extends DAOBase {
	private Statement stmt;

	public List<String[]> searchStudentPunch(String seki_no,String formEntryDate, String formClassroom) throws DatabaseException, SystemException {
		this.open();
		List<String[]> resultStudentPunch = new ArrayList<>();
		ResultSet rs = null;
		String sql = null;

		if(formClassroom.equals("all")) {
			sql = "SELECT * FROM TIME_TBL WHERE  SEKI_NO = " + seki_no  + " AND DATE_FORMAT(ENTRY_DATE, '%Y-%m-%d') = '"+ formEntryDate +"' ";
		}else {
			sql = "SELECT * FROM TIME_TBL WHERE  SEKI_NO = " + seki_no  + " AND DATE_FORMAT(ENTRY_DATE, '%Y-%m-%d') = '"+ formEntryDate +"' AND LOBE_ID = " + formClassroom;
		}

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
			String l_seki_no = rs.getString("SEKI_NO");
			String l_entry_date = rs.getString("ENTRY_DATE");
			String l_lobe_id = rs.getString("LOBE_ID");
			String[] dataLow = {l_seki_no,l_entry_date,l_lobe_id};
			resultStudentPunch.add(dataLow);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultStudentPunch;
	}

}
