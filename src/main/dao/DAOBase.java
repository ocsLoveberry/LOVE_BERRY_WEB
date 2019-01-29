package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.DAOParameters;
import main.parameter.ExceptionParameters;


public class DAOBase {

	Connection con;
	Statement stmt;

	protected void open() throws DatabaseException, SystemException {
		try {
			Class.forName(DAOParameters.DRIVER_NAME);
			con = DriverManager.getConnection(DAOParameters.CONNECT_STRING, DAOParameters.USERID,
					DAOParameters.PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SystemException(ExceptionParameters.SYSTEM_EXCEPTION_MESSAGE);
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MASSAGE, e);
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
	protected ResultSet executeQuery(String sql){
		ResultSet rs = null;
		try {
			this.open();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (DatabaseException | SystemException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}
}

/**
 * rsとconをクローズする処理が必要かも
 * @author ace
 */
