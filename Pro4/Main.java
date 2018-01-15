import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn;
        InitDB initiation = new InitDB();
        conn = initiation.initDB();
        Clients newClient = new Clients();
        Products newProduct = new Products();
        Orders newOrder = new Orders();
        try {
            newClient.addClient(conn, "Petrov", "Dmytro",123);
            newClient.addClient(conn, "Yahno", "Ivan",132);
            newClient.addClient(conn, "Ivanov", "Petro",213);
            newClient.addClient(conn, "Sidorov", "Oleg",231);
            newClient.addClient(conn, "Lato", "Vsevolod",321);
            newProduct.addProduct(conn, "Samsung", 5);
            newProduct.addProduct(conn, "Iphone", 50);
            newProduct.addProduct(conn, "Htc", 12);
            newProduct.addProduct(conn, "Sony", 20);
            newProduct.addProduct(conn, "LG", 34);
        } catch (Exception ex) {
            System.out.println("Error in DB -> check your clients and products");
        }

        Scanner sc = new Scanner(System.in);

        try {
            try {
                System.out.println("Enter your Client ID: ");
                int client = sc.nextInt();
                newClient.getIdClient(conn,client);
                System.out.println("Please, choose ID your device: ");
                    System.out.println("1: Samsung");
                    System.out.println("2: Iphone");
                    System.out.println("3: Htc");
                    System.out.println("4: Sony");
                    System.out.println("5: LG");
                int product = sc.nextInt();
                System.out.println("Please, choose quantity of product: ");
                int quantity = sc.nextInt();
                if (newProduct.getIdProduct(conn, product)) {
                    newOrder.addOrder(conn, client, product, quantity);
                    System.out.println("Your order is accepted");
                }

            } finally {
                if (conn != null) conn.close();
                sc.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error in DB -> check your client id");
           ex.printStackTrace();
            return;
        }
    }
}

