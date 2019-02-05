package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.parameter.DAOParameters;
import main.parameter.ExceptionParameters;


public class DAOBase {

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	protected void open(){
		try {
			Class.forName(DAOParameters.DRIVER_NAME);
			con = DriverManager.getConnection(DAOParameters.CONNECT_STRING, DAOParameters.USERID,
					DAOParameters.PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println(ExceptionParameters.SYSTEM_EXCEPTION_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE);
			e.printStackTrace();
		}
	}

	protected void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void close(Statement stmt, ResultSet rs) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			this.open();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(ExceptionParameters.PARAMETER_FORMAT_EXCEPTION_MESSAGE);
			e.printStackTrace();
		}
		return rs;

	}
}

/**
 * rsとconをクローズする処理が必要かも
 * @author ace
 */
