package data.models;

import data.SQLConnector;
import data.DatabaseEnum;

public class RegisterModel
{
    private SQLConnector sqlConn = new SQLConnector();

    public RegisterModel() throws Exception
    {
        sqlConn.getConnection(DatabaseEnum.MYSQL);
    }

    public void registerUser(String name,
                             String surname,
                             String user,
                             String password,
                             String email,
                             String address,
                             String phone) throws Exception
    {
        String def = "default";
        String [] columns = new String[12];
        String [] values = new String[12];
        values[0] = def;
        values[1] = name;
        values[2] = surname;
        values[3] = user;
        values[4] = password;
        values[5] = email;
        values[6] = address;
        values[7] = phone;
        values[8] = def;
        values[9] = def;
        values[10] = def;
        values[11] = def;
        sqlConn.insert("users", columns, values);
        sqlConn.closeConnection();
    }
}



