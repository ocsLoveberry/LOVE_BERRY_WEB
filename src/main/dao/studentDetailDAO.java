package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaBeans.studentDetailBean;
import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.ExceptionParameters;

public class studentDetailDAO extends DAOBase {
	private Statement stmt;

	/*
	 * @param seki_no
	 * 			学籍番号
	 * @return
	 * @throws DatabaseException
	 * @throws SystemException
	 * @author ace
	 */
	public ArrayList<studentDetailBean> getStudentDetail(String seki_no) throws DatabaseException, SystemException {
		//		学籍番号から各種情報（学籍番号、氏名、学科、専攻、クラス、入学年度、メッセージ、出欠状況、登録済みFeilca）を取り出してくる
		//			①まず、OCS_JOHO_TBLから学籍番号、氏名、学科、専攻、クラス、入学年度、メッセージを取ってくる
		//			②出欠状況を何かしらの方法で取ってくる
		//			③登録済みfelica情報を取ってくる
		//			④詳細ビーンズに渡して返すかー
		//

		ArrayList<studentDetailBean> studenDetailList;
		studenDetailList = new ArrayList<studentDetailBean>();
		String sql = "select * from OCS_JOHO_TBL where SEKI_NO = '" + seki_no + "'";
		try {
			this.open();
			stmt = con.createStatement();
//			①
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			String name = rs.getString("NAME");
			String department = rs.getString("GAKKA_CD");
			String major = rs.getString("SENKO_CD");
			String studentClass = rs.getString("CLASS_CD");
//			②
			String[] class1AttendanceCheck = getAttendanceClass1(seki_no);
/**
 * 		@TODO 入学年度を取得する方法
 */
			String admissionYear = "20" + seki_no.substring(0, 2);
			String message = rs.getString("MESSAGE");
//			③
			String sql2 = "select * from FELICA_TBL where SEKI_NO = '" + seki_no + "'";
			ResultSet rs2 = stmt.executeQuery(sql2);
//			次の行が存在するか（Felicaが登録されているか)
			boolean isExists = rs2.next();
			String studentFelicaID1 = "";
			String studentFelicaID2 = "";
			if(isExists){
				studentFelicaID1 = rs2.getString("IDM1");
				studentFelicaID2 = rs2.getString("IDM2");
//			String studentFelicaEntryDate = rs2.getString("ENTRY_DATE");	//登録日時を表示するのはどっちでもいいらしい
			}
			studenDetailList.add(new studentDetailBean(seki_no, name, department, major, studentClass, admissionYear, message,studentFelicaID1,studentFelicaID2));
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
		} finally {
			this.close(stmt);
		}
//		④
		System.out.println("nullなん？"+studenDetailList.isEmpty());
		return studenDetailList;
	}

//	TODO:出席を判定するプログラムかDBの値を表示させるもしくは、出席を消す
	public String[] getAttendanceClass1(String seki_no) {
		String sql = "select * from ";
		String[] result = null;
		return result;
	}
}
