package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.TeacherSearchBeans;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Search_teacherDAO extends DAOBase{
	private Statement stmt;
	public ArrayList<TeacherSearchBeans> search_teacher_select_name(String NAME) throws DatabaseException, SystemException {
		ArrayList<TeacherSearchBeans> teachersList;
		teachersList= new ArrayList<TeacherSearchBeans>();
		String sql = "select * " +
					"from OCS_JOHO_TBL " +
					"where TYPE = 1 AND NAME like '%" + NAME + "%'";

		int count = 0;
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				teachersList.add(new TeacherSearchBeans(rs.getString("SEKI_NO"),rs.getString("NAME"),rs.getString("MAIL_ADDRESS"),rs.getString("MESSAGE")));
				System.out.println(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		}finally {
			this.close(stmt);
			System.out.println(count);
		}
		System.out.println(teachersList.get(0).getName());
		System.out.println("teachersList.isNullEmpty():" + !teachersList.isEmpty());
		return teachersList;
	}

	public ArrayList<TeacherSearchBeans> search_teacher_select_seki_num(String SEKI_NO) throws DatabaseException, SystemException {
		ArrayList<TeacherSearchBeans> teachersList = new ArrayList<TeacherSearchBeans>();
			 String sql = "select * " +
					 	  "from OCS_JOHO_TBL " +
					 	  "where OCS_JOHO_TBL.SEKI_NO = " + SEKI_NO + " and OCS_JOHO_TBL.TYPE = 1 ";
			try {
				this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				teachersList.add(new TeacherSearchBeans(rs.getString("SEKI_NO"),rs.getString("NAME"),rs.getString("MAIL_ADDRESS"),rs.getString("MESSAGE")));
				}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
			return teachersList;
	}
}

