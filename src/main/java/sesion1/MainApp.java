package sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/prueba",
                "root",
                ""
        );

        Statement stmt= con.createStatement();

        int resultUpdate =  stmt.executeUpdate("update Users set city='Rosario' where name='Messi'");

        ResultSet result = stmt.executeQuery("select * from Users");

        while(result.next()){

            //System.out.println(result.getString(0));

            //if(result.getString("name").equals("Ronaldo")) {
                System.out.println(result.getString("IdUser"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("phone"));
                System.out.println(result.getString("city"));
            //}
        }
    }
}
