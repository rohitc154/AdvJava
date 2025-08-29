
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAggVal {
    public static void main(String[] args) throws  Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
        Statement st = con.createStatement();
        String sql = "Select count(*) from employee1";
        // We always consider the database order i.e., here is only 1 row and 1 column        
        ResultSet rs = st.executeQuery(sql);
        // It also checks for does any value is available in the resultset or not !!
        if (rs.next()) {
            System.out.println("The no. of employee is : "+rs.getInt(1));
        }
        con.close();
    }
} 
