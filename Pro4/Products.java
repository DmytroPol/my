import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Products {
    private int idProduct;
    private String nameProduct;
    private int quantityProduct;

    public void addProduct(Connection conn, String nameProduct, int quantityProduct) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Products (nameProduct, quantityProduct) VALUES(?, ?)");
        try {

            ps.setString(1, nameProduct);
            ps.setInt(2, quantityProduct);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    public boolean getIdProduct(Connection conn, int idProduct) throws Exception {
        boolean isExist = false;
        PreparedStatement ps = conn.prepareStatement("SELECT idProduct FROM Products WHERE idProduct = ?");
        try {
            // table of data representing a database result set,
            ps.setInt(1, idProduct);
            ResultSet rs = ps.executeQuery();
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                while (rs.next()) {
                    isExist = true;
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
        return isExist;
    }
}
