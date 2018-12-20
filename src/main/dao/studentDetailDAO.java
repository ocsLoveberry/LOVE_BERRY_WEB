package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.OcsJohoData;
import javaBeans.studentDetailBean;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class studentDetailDAO extends DAOBase {
		private Statement stmt;
	public ArrayList<studentDetailBean> getStudentDetail(String seki_no) throws DatabaseException, SystemException {
//		学籍番号から各種情報（学籍番号、氏名、学科、専攻、クラス、入学年度、メッセージ、出欠状況、登録済みFeilca）を取り出してくる
//			まず、OCS_JOHO_TBLから学籍番号、氏名、学科、専攻、クラス、入学年度、メッセージを取ってくる
//			出欠状況を何かしらの方法で取ってくる
//			登録済みfelica情報を何かしらの方法で取ってくる
//			詳細ビーンズに渡して返すかー
//

		ArrayList<studentDetailBean> studenDetailList;
		studenDetailList = new ArrayList<studentDetailBean>();
		String sql = "select * from OCS_JOHO_TBL where SEKI_NO = '" + seki_no +"'";
		try {
			this.open();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("NAME");
				String department = rs.getString("GAKKA_CD");
				String major = rs.getString("SENKO_CD");
				String studentClass = rs.getString("CLASS_CD");
				String admissionYear = "2015";
				String message = rs.getString("MESSAGE");
				studenDetailList.add(new studentDetailBean(seki_no, name, department, major, studentClass, admissionYear, message));
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}

		return studenDetailList;

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
		}catch (SystemException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt);
		}

		return studentList;
	}
}
