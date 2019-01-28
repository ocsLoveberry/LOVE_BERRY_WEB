package main.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class AddClassSubjectsDAO extends DAOBase{
	private Statement stmt;

	public int add_subjects(String class_cd, String subjects_cd, String year) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			String sql = "INSERT INTO CLASS_SUBJECTS_TBL (CLASS_CD,SUBJECTS_CD,YEAR) VALUES( '" + class_cd + "' , '" + subjects_cd + "' , '" + year + "' )";
			stmt = con.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return num;
	}

	public void add_student(String class_cd, String subjects_cd, String year) throws DatabaseException, SystemException {
		this.open();
		int num = 0;
		try {
			Search_studentDAO ssDAO = new Search_studentDAO();
			ArrayList<String> studentsList = new ArrayList<String>();
			studentsList = ssDAO.search_student(class_cd,year);
			String sql="";
			for(int i=0; i<studentsList.size();i++){
				sql ="INSERT INTO SUBJECTS_TBL (SEKI_NO,SUBJECTS_CD,YEAR) VALUES('" + studentsList.get(0) + "' ,'" + subjects_cd + "' ,'" + year + "' )";
				stmt = con.createStatement();
				num = stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}
}
