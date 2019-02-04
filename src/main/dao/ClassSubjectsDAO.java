package main.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.ClassSubjects;

public class ClassSubjectsDAO extends DAOBase {

	Statement stmt;

	public ArrayList<ClassSubjects> selectAll(){
		ArrayList<ClassSubjects> classSubjects;
		classSubjects = new ArrayList<ClassSubjects>();
		String sql = "SELECT DISTINCT CLASS_CD, SUBJECTS_CD, YEAR FROM CLASS_SUBJECTS_TBL GROUP BY CLASS_CD";
		ResultSet rs = null;
		try {
			this.open();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String class_cd = rs.getString("CLASS_CD");
				String subjects_cd = rs.getString("SUBJECTS_CD");
				String year = rs.getString("YEAR");
				classSubjects.add(new ClassSubjects(class_cd, subjects_cd, year));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return classSubjects;
	}

}
