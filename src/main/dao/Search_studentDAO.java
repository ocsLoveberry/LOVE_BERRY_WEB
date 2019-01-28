/**
 * 2018/12/19
 * seki_noだけで検索するメソッドを追加
 * @author ace
 */

package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class Search_studentDAO extends DAOBase{
	private Statement stmt;

	public ArrayList<String> search_student(String class_cd,String year) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> studentsList = new ArrayList<String>();
		try {
			//if()で選択肢の判定必要
			String sql = "select SEKI_NO from OCS_JOHO_TBL where CLASS_CD = '" + class_cd + "' AND YEAR = '" + year + "'";

			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				studentsList.add(rs.getString("SEKI_NO"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
		return studentsList;
	}
}
