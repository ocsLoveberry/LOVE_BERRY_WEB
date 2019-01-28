package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class RoomListDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> list() throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> room_list = new ArrayList<String>();
		try {
			String sql = "select ROOM_CD from ROOM_LIST_TBL";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				room_list.add(rs.getString("ROOM_CD"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return room_list;
	}

	public ArrayList<String> to_name(ArrayList<String> room_cd) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> room_name = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs;
			String sql;
			for(int i=0; i<room_cd.size();i++){
				sql = "select ROOM_NAME from ROOM_LIST_TBL where ROOM_CD = '" + room_cd.get(i) + "'";
				rs = stmt.executeQuery(sql);
				rs.next();
				room_name.add(rs.getString("ROOM_NAME"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return room_name;
	}
}
