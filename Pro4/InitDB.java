import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB  {

    public static Connection conn;

    public Connection initDB() {

        String DB_CONNECTION = "jdbc:mysql://localhost:3306/test12";
        String DB_USER = "root";
        String DB_PASSWORD = "root";

        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            Statement st = conn.createStatement();
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("DROP TABLE IF EXISTS Products");
            st.execute("DROP TABLE IF EXISTS Orders");
            st.execute("CREATE TABLE Clients (idClient int AUTO_INCREMENT NOT NULL PRIMARY KEY, surname VARCHAR(60) NOT NULL, name VARCHAR(60) NOT NULL, phone INT NOT NULL )");
            st.execute("CREATE TABLE  Products (idProduct int AUTO_INCREMENT NOT NULL PRIMARY KEY, nameProduct VARCHAR(60) NOT NULL, quantityProduct int)");
            st.execute("CREATE TABLE  Orders (idOrder int AUTO_INCREMENT NOT NULL PRIMARY KEY, idClient int, idProduct int, quantity int)");


        } catch (SQLException esql) {
            System.out.println("Error in DB -> please check the connection, user name and password");
        }
        return conn;
    }


}

