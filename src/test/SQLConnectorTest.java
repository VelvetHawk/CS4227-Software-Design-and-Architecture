
//import org.junit.*;
//import org.junit.jupiter.api.Test;
////import static org.junit.jupiter.api.Assertions.assertEquals;
//import java.sql.Connection;
//import java.sql.*;
//import data.SQLConnector;
//import org.junit.jupiter.api.Test;
//import java.sql.ResultSet;
//import org.junit.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class SQLConnectorTest
//{
//    SQLConnector sqlconnect = new SQLConnector();
//    String [] columns = {"username", "password"};
//
//    @Test
//    public void test(){
//
//    }
//
//    @Test
//    public void testUpdate(){
//        try {
//            sqlconnect.getConnection();
//        }
//        catch(Exception e){
//
//        }
//        String [] columns = {"username", "password"};
//        String [] values = {"Mikeyo", "pass123"};
//        boolean updated = sqlconnect.update("users", columns, values, "WHERE User_ID = 4" );
//        System.out.println(updated);
//        assertEquals(updated,true);
//        assertTrue(updated);
//    }
//
//    @Test
//    public void testSelect(){
//
//        String [] columns = {"username", "password"};
//        try {
//            sqlconnect.getConnection();
//        }
//        catch(Exception e){
//
//        }
//        ResultSet rs = sqlconnect.select("users", columns, null, null);
//    }
//
//    @Test
//    public void testInsertDelete(){
//        String [] columns = {"username", "password"};
//        String [] values = {"default", "'jim'", "'bloggs'", "'testuser'", "'pass'", "'@gmail'", "'ennis'", "'087'", "default", "default", "default", "default"};
//        try {
//            sqlconnect.getConnection();
//        }
//        catch(Exception e){
//
//        }
//        boolean insertSuccess = sqlconnect.insert("restaurant_db.users", columns, values);
//        assertTrue(insertSuccess);
//        boolean deleteSuccess = sqlconnect.delete("restaurant_db.users", "WHERE username = 'testuser'");
//        assertTrue(deleteSuccess);
//
//    }
//}
//
//
//


/*
import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Connection;
import java.sql.*;
*/

//import data.SQLConnector;
//import org.junit.jupiter.api.Test;
//import data.DatabaseEnum;
//
//import java.sql.ResultSet;
//
////import org.junit.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class SQLConnectorTest {
//    SQLConnector sqlconnect = new SQLConnector();
//    String [] columns = {"username", "password"};
//
//    @Test
//    public void test(){
//
//    }
//
//    @Test
//    public void testConnection(){
//        try {
//            sqlconnect.getConnection(DatabaseEnum.AWS);
//        }
//        catch(Exception e){
//
//        }
//    }
//
//
//    @Test
//    public void testUpdate(){
//        try {
//            sqlconnect.getConnection(DatabaseEnum.MYSQL);
//        }
//        catch(Exception e){
//
//        }
//        String [] columns = {"username", "password"};
//        String [] values = {"Mikeyo", "pass123"};
//        boolean updated = sqlconnect.update("users", columns, values, "WHERE User_ID = 4" );
//        System.out.println(updated);
//        assertEquals(updated,true);
//        assertTrue(updated);
//    }
//
//    @Test
//    public void testSelect(){
//
//        String [] columns = {"username", "password"};
//        try {
//            sqlconnect.getConnection(DatabaseEnum.MYSQL);
//        }
//        catch(Exception e){
//
//        }
//        ResultSet rs = sqlconnect.select("users", columns, null, null);
//    }
//
//    @Test
//    public void testInsertDelete(){
//        String [] columns = {"username", "password"};
//        String [] values = {"default", "jim", "bloggs", "testuser", "pass", "@gmail", "ennis", "087", "default", "default", "default", "default"};
//        try {
//            sqlconnect.getConnection(DatabaseEnum.MYSQL);
//        }
//        catch(Exception e){
//
//        }
//        boolean insertSuccess = sqlconnect.insert("Restaurant_db.users", columns, values);
//        assertTrue(insertSuccess);
//        boolean deleteSuccess = sqlconnect.delete("Restaurant_db.users", "WHERE username = 'testuser'");
//        assertTrue(deleteSuccess);
//
//    }
//
//
//
//
//}





