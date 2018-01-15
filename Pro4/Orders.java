import java.sql.*;

public class Orders {
    private int idOrder;
    private int idClient;
    private int idProduct;
    public static Connection conn;

    public void addOrder(Connection conn, int idClient, int idProduct, int quantity) throws Exception {

        PreparedStatement ps = conn.prepareStatement("INSERT INTO Orders (idClient, idProduct, quantity) VALUES(?, ?, ?)");
        try {

            ps.setInt(1, idClient);
            ps.setInt(2, idProduct);
            ps.setInt(3, quantity);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }
}