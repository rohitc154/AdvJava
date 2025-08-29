
import java.sql.*;
import java.util.Scanner;

public class selectNthSal {
    public static void main(String[] args)  throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
        Statement st = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of salary you want to  know : ");
        int val = sc.nextInt();

        String countQuery = "Select count(*) from employee1";
        ResultSet rs2 = st.executeQuery(countQuery);
        if (rs2.next() && rs2.getInt(1) >= val) {
            String sqlQuery = "Select * from (Select eno,ename,esal,eadd,rank() over(order by esal desc) ranking from employee1) where ranking =" +val;
            ResultSet rs = st.executeQuery(sqlQuery);
            while (rs.next())
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        }else{
            System.out.println("Doesn't exist !!");
        }
    }
}
