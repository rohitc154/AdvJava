import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCheck {
    public static void main(String[] args) {
        String user = "JustCode";
        String pwd = "code&coffee";
        String url = "jdbc:oracle:thin:@//localhost:1521/XE"; // Use service name format

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pwd);

            if (con != null && !con.isClosed()) {
                System.out.println("✅ JDBC connection established successfully!");

            } else {
                System.out.println("❌ Failed to establish JDBC connection.");
            }

            // Close connection
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Add ojdbc jar to classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception while connecting to DB.");
            e.printStackTrace();
        }
    }
}
