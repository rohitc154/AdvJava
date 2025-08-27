import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchMovies {
    public static void main(String[] args) {
        String user = "JustCode";
        String pwd = "code&coffee";
        String url = "jdbc:oracle:thin:@localhost:1521/xe"; // Service name connection

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pwd);

                System.out.println("JDBC connection established successfully!\n");

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM JustCode.movies");

                System.out.println("Movie Records:");
                System.out.println("ID\tName\t\tHero\t\tHeroine");

     
                while (rs.next()) {
                    System.out.println(
                        rs.getInt(1) + "\t" +
                        rs.getString(2) + "\t" +
                        rs.getString(3) + "\t" +
                        rs.getString(4)
                    );
                }
                rs.close();
                st.close();
                con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Add ojdbc jar to classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception while connecting or fetching data.");
            e.printStackTrace();
        }
    }
}
