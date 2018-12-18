package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import main.exception.DatabaseException;
import main.exception.SystemException;
import main.parameter.DAOParameters;
import main.parameter.ExceptionParameters;


public class DAOBase {

	Connection con;

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

	protected void close(Statement stmt) throws DatabaseException {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DatabaseException(ExceptionParameters.DATABASE_CLOSE_EXCEPTION_MESSAGE, e);
		}
	}
}
