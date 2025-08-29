import java.sql.*;
import java.util.Scanner;

public class ExecuteMethod {
    public static void main(String[] args) throws  Exception{

        Scanner input = new Scanner(System.in);

        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
        Statement st = con.createStatement();

        System.out.println("Enter SQL Query : (Don't use ';' while writing query :)");
        String query = input.nextLine();

        boolean b = st.execute(query);
        if (b == true) {
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
            }
        }else{
            int val = st.getUpdateCount();
            System.out.println("The no. of records affected are : "+val);
        }
        con.close();
    }
}
