import java.sql.*;

public class Clients {

    private int idClient;
    private String surname;
    private String name;
    private int phone;
    public static Connection conn;

    public static void addClient(Connection conn, String surname, String name, Integer phone) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients (surname, name, phone) VALUES(?, ?, ?)");
        try {

            ps.setString(1, surname);
            ps.setString(2, name);
            ps.setInt(3, phone);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    public static void getIdClient(Connection conn, int idClient) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE idClient =?");
        try {
            // table of data representing a database result set,
            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                while (rs.next()) {
                    int j = 0;
                    for (int i = 2; i <= md.getColumnCount(); i++) {
                        j++;
                        if (j == 3) {
                            System.out.print("Hello! ");
                            break;
                        }
                        System.out.println(rs.getString(i) + "\t\t");
                    }
                    for (int i = 4; i <= md.getColumnCount(); i++) {
                        j++;
                        if (j == 4) {
                            System.out.print("Your phone number -> ");
                            System.out.println(rs.getString(i) + "\t\t");
                        }
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
    }
}
