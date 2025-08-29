import java.sql.*;
public class SelectParti {
    public static void main(String[] args)throws  Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select ename from employee1");
        while (rs.next()) {
            
            // System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
            System.out.println(rs.getString(1));
        }
        con.close();
    }
}
