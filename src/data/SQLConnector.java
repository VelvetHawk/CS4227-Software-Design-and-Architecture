package data;

import framework.Framework;
import framework.context.ErrorContext;

import java.sql.Connection;
import java.sql.*;

public class SQLConnector implements DatabaseConnector
{
    private String tablename = "$tablename";
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    
    @Override
    public void getConnection(DatabaseEnum val) throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            if (val == DatabaseEnum.MYSQL)
                mysqlConnect();
            else // If user has requested to use AWS database
                awsConnect();
        }
        catch(ClassNotFoundException exc)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Class could not be found by JDBC",
                    exc
                )
            );
            throw exc;
        }
    }

    private void awsConnect() throws Exception
    {
        try
        {
            String publicDNS = "cs4125-db-instance.c1qi1r4muekc.us-east-2.rds.amazonaws.com";
            String port = "3306";
            String database = "Restaurant_db";
            String remoteDatabaseUsername = "remoteuser";
            String databaseUserPassword = "remotepassword";
            conn = DriverManager.getConnection("jdbc:mysql://" + publicDNS + ":" + port + "/" + database, remoteDatabaseUsername, databaseUserPassword);
        }
        catch (SQLException e)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during connection to AWS",
                    e
                )
            );
        }
    }

    private void mysqlConnect() throws Exception
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant_DB?", "root", "");
        }
        catch(SQLException exc)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error while connecting to database",
                    exc
                )
            );
            throw exc;
        }
    }

    public ResultSet select(String table, String[] columns, String whereClause, String orderByClause)
    {
        StringBuilder strQuery = new StringBuilder("Select");
        for (int i = 0; i < columns.length; i++)
        {
            strQuery.append(" ").append(columns[i]);
            if (i+1 < columns.length)
                strQuery.append(", ");
        }
        strQuery.append(" FROM $tablename");
        if (whereClause != null)    strQuery.append(whereClause);
        if (orderByClause != null)  strQuery.append(orderByClause);
        String sql = strQuery.toString().replace(tablename,table);
        try
        {
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement);
            rs = preparedStatement.executeQuery();
        }
        catch(Exception e)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during selection",
                    e
                )
            );
        }
        return rs;
    }

    public boolean update(String table, String[] columns, String[] values, String whereClause)
    {
        StringBuilder strQuery = new StringBuilder("Update $tablename SET");
        for(int i = 0; i < columns.length; i++)
        {
            String set = " " + columns[i] + "=" + "'" + values[i] + "'";
            strQuery.append(set);
            if(i + 1 < columns.length) {
                strQuery.append(", ");
            }
        }
	    strQuery.append(" ").append(whereClause);
        String sql = strQuery.toString().replace(tablename,table);
        System.out.println(sql);
        int registerSuccess = 0;
        try
        {
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement);
            registerSuccess = preparedStatement.executeUpdate();
	        return registerSuccess > 0;
        }
        catch(Exception e)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during update",
                    e
                )
            );
            return false;
        }
    }

    public boolean insert(String table, String[] columns, String[] values)
    {
        StringBuilder strQuery = new StringBuilder("INSERT INTO $tablename values( ");
        for(int i = 0; i < values.length; i++)
        {
            //if value to be inserted isn't default add '' to make it valid
            if(!values[i].equals("default"))
                strQuery.append("'").append(values[i]).append("'");
            else
                strQuery.append(values[i]);
            if (i + 1 < values.length)
                strQuery.append(", ");
        }
        strQuery.append(")");
        String sql = strQuery.toString().replace(tablename,table);
        System.out.println(sql);
        int registerSuccess;
        try
        {
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement);
            registerSuccess = preparedStatement.executeUpdate();
	        return registerSuccess > 0;
        }
        catch(Exception e)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during insert",
                    e
                )
            );
            return false;
        }
    }

    public boolean delete(String table, String whereClause)
    {
        String strQuery = "DELETE FROM $tablename";
        String sql =strQuery.replace(tablename,table);
        sql += " " + whereClause;
        int deleteSuccess;
        try
        {
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement);
            deleteSuccess = preparedStatement.executeUpdate();
	        return deleteSuccess > 0;
        }
        catch(Exception e)
        {
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during deletion",
                    e
                )
            );
            return false;
        }
    }
    
    public void closeConnection() throws Exception
    {
        conn.close();
    }
}





