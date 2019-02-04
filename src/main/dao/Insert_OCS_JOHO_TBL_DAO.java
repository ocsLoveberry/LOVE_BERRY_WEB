package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javaBeans.OcsJohoData;

public class Insert_OCS_JOHO_TBL_DAO extends DAOBase {
	private PreparedStatement pstmt;

	public boolean Insert_OCS_JOHO_TBL(OcsJohoData newStudentInfomation) throws SQLIntegrityConstraintViolationException{
		String sql = "INSERT INTO OCS_JOHO_TBL (seki_no,type,name,message,password,mail_address,gakka_cd,senko_cd,class_cd,year,tannin_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		int result = 0;
		try {
			this.open();
			pstmt = con.prepareStatement(sql);
			setPstmt(pstmt,newStudentInfomation);
			result = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(pstmt,rs);
		}
		boolean isInsertOk = false;
		if(result > 0) {
			isInsertOk = true;
		}
		return isInsertOk;
	}

	private void setPstmt(PreparedStatement pstmt, OcsJohoData newStudentInfomation) throws SQLException {
		/**
		 * 順番は以下の通り
		 * 1	seki_no
		 * 2	type
		 * 3	name
		 * 4	message
		 * 5	password
		 * 6	mail_adress
		 * 7	gakka_cd
		 * 8	senko_cd
		 * 9	class_cd
		 * 10	year
		 * 11	tannin_flag
		 */
		pstmt.setString(1, newStudentInfomation.getSeki_no());
		pstmt.setString(2, newStudentInfomation.getType());
		pstmt.setString(3, newStudentInfomation.getName());
		pstmt.setString(4, newStudentInfomation.getMessage());
		pstmt.setString(5, newStudentInfomation.getPassword());
		pstmt.setString(6, newStudentInfomation.getMail_address());
		pstmt.setString(7, newStudentInfomation.getGakka_cd());
		pstmt.setString(8, newStudentInfomation.getSenko_cd());
		pstmt.setString(9, newStudentInfomation.getClass_cd());
		pstmt.setString(10, newStudentInfomation.getYear());
		pstmt.setString(11, "0");		//生徒は基本0、教師のみ1か0を持つ
	}

}
