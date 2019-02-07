package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.SubjectsListTable;

public class SubjectsListTableDAO extends DAOBase{

	Statement stmt;

	public ArrayList<SubjectsListTable> selectAll() {
		ArrayList<SubjectsListTable> SubjectsList;
		SubjectsList = new ArrayList<>();
		final String sql = "SELECT * FROM SUBJECTS_LIST_TBL";
		ResultSet rs = null;

		try {
			this.open();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String subjects_cd = rs.getString("subjects_cd");
				String subjects_name = rs.getString("subjects_name");
				SubjectsList.add(new SubjectsListTable(subjects_cd, subjects_name));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt, rs);
		}

	return SubjectsList;
}
}
