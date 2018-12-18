package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class CheckJikanwari extends DAOBase{
	private Statement stmt;

	public void check_update(ArrayList<String> class_cd,String tokutei_cd,String start_date,String start_time_cd) throws DatabaseException, SystemException {
		this.open();
		ArrayList<String> subjects_name = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs;
			String sql;
			String count;
			for(int i=0; i<class_cd.size();i++){
				sql = "select COUNT(*) from JIKANWARI_TBL where CLASS_CD = '" + class_cd.get(i) + "' AND TOKUTEI_CD = '" + tokutei_cd + "'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					count = rs.getString("COUNT(*)");
					if(count.equals("0")) {
						sql = "INSERT INTO JIKANWARI_TBL (CLASS_CD,START_DATE,START_TIME_CD,TOKUTEI_CD) VALUES( '" + class_cd.get(i) + "' , '" + start_date + "' , '" + start_time_cd + "' , '" + tokutei_cd + "' )";
						int num = stmt.executeUpdate(sql);
					}
				}
				}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
	}
}
