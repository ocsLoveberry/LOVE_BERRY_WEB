package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.OcsJohoData;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Search_OCS_JOHO_TBL_DAO extends DAOBase {
		private Statement stmt;
	public ArrayList<OcsJohoData> search_OCS_JOHO_TBL_by_sekiNo(String seki_no) throws DatabaseException, SystemException {
		ArrayList<OcsJohoData> studentList;
		studentList = new ArrayList<OcsJohoData>();
		String sql = "select * from OCS_JOHO_TBL where SEKI_NO = '" + seki_no +"'";
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				studentList.add(new OcsJohoData(rs.getString("SEKI_NO"),rs.getString("NAME"),rs.getString("MESSAGE")));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return studentList;
	}

	public ArrayList<OcsJohoData> search_OCS_JOHO_TBL_by_name(String name) throws DatabaseException, SystemException {
		ArrayList<OcsJohoData> studentList;
		studentList = new ArrayList<OcsJohoData>();
//		学生(TYPE=3)かつnameが部分一致するで検索する
		String sql = "select * from OCS_JOHO_TBL where TYPE = 3 AND NAME like '%" + name +"%'";
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				studentList.add(new OcsJohoData(rs.getString("SEKI_NO"),rs.getString("NAME"),rs.getString("MESSAGE")));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return studentList;
	}
}