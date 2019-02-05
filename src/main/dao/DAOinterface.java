package main.dao;

import java.util.ArrayList;

public interface DAOinterface {

	public ArrayList<?> selectAll();
	public ArrayList<?> selectWhere(String where);
	public boolean deleteWhere(String where);
	public boolean insert();
}
