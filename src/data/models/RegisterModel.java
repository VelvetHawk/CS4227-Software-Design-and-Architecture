package data.models;

import data.SQLConnector;
import data.DatabaseEnum;

public class RegisterModel
{
    private boolean registered = false;
    private SQLConnector SQLConn = new SQLConnector();

    public RegisterModel() throws Exception
    {
        SQLConn.getConnection(DatabaseEnum.MYSQL);
    }

    public boolean checkRegistered(String user, String pass)
    {
        //TODO: check if registered
        return registered;
    }

    public boolean getRegistered()
    {
        return registered;
    }

    public void registerUser(String name,
                             String surname,
                             String user,
                             String password,
                             String email,
                             String address,
                             String phone) throws Exception
    {
        String [] columns = new String[12];
        String [] values = new String[12];
        values[0] = "default";
        values[1] = name;
        values[2] = surname;
        values[3] = user;
        values[4] = password;
        values[5] = email;
        values[6] = address;
        values[7] = phone;
        values[8] = "default";
        values[9] = "default";
        values[10] = "default";
        values[11] = "default";
        registered = SQLConn.insert("users", columns, values);
        SQLConn.closeConnection();
    }
}



