package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.lobeBean;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Search_LOBE_TBL_DAO extends DAOBase {
		private Statement stmt;
	public ArrayList<lobeBean> search_LOBE_TBL_by_classroomName(String classroomName) throws DatabaseException, SystemException {
		ArrayList<lobeBean> lobeList;
		lobeList = new ArrayList<lobeBean>();
		String sql = "";
		if(classroomName.equals("all")) {
			sql = "select * from LOBE_TBL";
		}else {
			sql = "select * from LOBE_TBL where ROOM_CD = '" + classroomName +"'";
		}
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				lobeList.add(new lobeBean(rs.getString("LOBE_ID"),rs.getString("ROOM_CD")));
				System.out.println(rs.getString("LOBE_ID"));
				System.out.println(rs.getString("ROOM_CD"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return lobeList;
	}

	public ArrayList<lobeBean> search_OCS_JOHO_TBL_by_lobeID(String lobeID) throws DatabaseException, SystemException {
		ArrayList<lobeBean> lobeList;
		lobeList = new ArrayList<lobeBean>();
//		学生(TYPE=3)かつnameが部分一致するで検索する
		String sql = "select * from LOBE_TBL where LOBE_ID = '" + lobeID + "'";
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				lobeList.add(new lobeBean(rs.getString("LOBE_ID"),rs.getString("ROOM_CD")));
				System.out.println(rs.getString("LOBE_ID"));
				System.out.println(rs.getString("ROOM_CD"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return lobeList;
	}
}
