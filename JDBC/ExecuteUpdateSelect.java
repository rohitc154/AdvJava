
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteUpdateSelect {
    public static void main(String[] args) throws Exception {
        String user = "JustCode";
        String pwd = "code&coffee";
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pwd);
        Statement st = con.createStatement();
        // st.executeUpdate("DROP TABLE emp5");
        int rowCount = st.executeUpdate("create table emp5(eno number)");
        System.out.println(rowCount);
        con.close();
    }
}
