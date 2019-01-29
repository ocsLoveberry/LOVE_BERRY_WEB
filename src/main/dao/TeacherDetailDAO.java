package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.teacherDetailBean;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class TeacherDetailDAO extends DAOBase {
	private Statement stmt;

	public ArrayList<teacherDetailBean> getStudentDetail(String seki_no)
			throws DatabaseException, SystemException {

		ArrayList<teacherDetailBean> teacherDetailList;
		teacherDetailList = new ArrayList<teacherDetailBean>();
		String sql_ocs_joho_tbl_all = "select * from OCS_JOHO_TBL where SEKI_NO = '" + seki_no + "'";
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql_ocs_joho_tbl_all);
			rs.next();
			String name = rs.getString("NAME");
			String message = rs.getString("MESSAGE");
			String sql_felica_all = "select * from FELICA_TBL where SEKI_NO = '" + seki_no + "'";
			ResultSet rsfelica = stmt.executeQuery(sql_felica_all);

//			次の行が存在するか（Felicaが登録されているか)
			boolean isExists = rsfelica.next();
			String teacherFelicaID1 = "";
			String teacherFelicaID2 = "";
			if(isExists){
				teacherFelicaID1 = rsfelica.getString("IDM1");
				teacherFelicaID2 = rsfelica.getString("IDM2");
			}
			teacherDetailList.add(new teacherDetailBean(seki_no, name,message,teacherFelicaID1,teacherFelicaID2));
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
//		④
		System.out.println("nullなん？"+teacherDetailList.isEmpty());
		return teacherDetailList;
	}
}
