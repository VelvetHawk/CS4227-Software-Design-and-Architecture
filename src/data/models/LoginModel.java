package data.models;

import java.sql.*;
import data.SQLConnector;
import data.DatabaseEnum;

public class LoginModel
{
    private boolean loginValid = false;

    public boolean getLogin()
    {
        return loginValid;
    }

    public void loginValidation(String user, char [] passChars ) throws Exception
    {
        if (passChars != null)
        {
            String pass = new String(passChars);
            //add '' to values to allow them to be added to sql queries
            user = "'" + user  + "'";
            pass = "'" + pass + "'";
            SQLConnector SQLconn = new SQLConnector();
            SQLconn.getConnection(DatabaseEnum.MYSQL);
            String [] columns = {"username", "password"};
            ResultSet rs = SQLconn.select("users", columns, " WHERE username =" + user + " AND PASSWORD =" + pass, null );
	        loginValid = rs.next();
            rs.close();
            SQLconn.closeConnection();
        }
    }
}

