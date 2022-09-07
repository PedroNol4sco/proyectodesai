package sesion1;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/prueba",
                "root",
                ""
        );

        //Statement stmt2 = con.createStatement();
        //ResultSet resultSet = stmt2.executeQuery("select * from Users where name='Ronaldo'");

       // while(resultSet.next()){
            //System.out.println(resultSet.getString("name") + "\n"+
            //resultSet.getString("phone") +"\n"+
            //resultSet.getString("city"));
       // }

        //---------

        //PreparedStatement preparedStatement =
        //        con.prepareStatement("select * from Users where name=? and city=?");

        //preparedStatement.setString(1, "Cueva");
        //preparedStatement.setString(2, "Lima");

        //ResultSet resultSet2 = preparedStatement.executeQuery();

        //while(resultSet2.next()){
        //   System.out.println(resultSet2.getString("name") + "\n"+
        //            resultSet2.getString("phone") +"\n"+
        //           resultSet2.getString("city"));
        //}

       //---------

        Statement stCreate = con.createStatement();

        int filasAfectadas=
                stCreate.executeUpdate("INSERT INTO Users VALUES (6,'Maria', '934537423', 'Quito')");
        //UPDATE Users SET name = 'Juan' WHERE idUser = 1

                System.out.println("Filas Afectadas: " + filasAfectadas);
                PreparedStatement preparedStatement =
                        con.prepareStatement("select * from Users where name=?");

                preparedStatement.setString(1,"Maria");
                ResultSet resultSet3 = preparedStatement .executeQuery();

        while(resultSet3.next()) {
            System.out.println(resultSet3.getString("name") + "\n" +
                    resultSet3.getString("phone") + "\n" +
                    resultSet3.getString("city"));
        }
    }
}
