package data;

import java.sql.*;

public interface DatabaseConnector
{
	public void getConnection(DatabaseEnum val) throws Exception;
	public boolean insert(String table, String[] columns, String[] values);
	public ResultSet select(String table, String[] columns, String whereClause, String orderByClause);
	public boolean update(String table, String[] columns, String[] values, String whereClause);
	public boolean delete(String table, String whereClause);
}

