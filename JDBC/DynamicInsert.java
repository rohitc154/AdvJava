import java.sql.*;
import java.util.Scanner;

public class DynamicInsert {
    public static void main(String[] args) throws  Exception{
        Scanner input = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        
        System.out.println("Enter Emp No. :- ");
        int eno = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Name :- ");
        String ename = input.nextLine();
        System.out.println("Enter Emp Salary :- ");
        double esal = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Emp Address :- ");
        String eadd = input.nextLine();

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
        Statement st = con.createStatement();

        // String query = "insert into employee1 values (" + eno + ", '" + ename + "', " + esal + ", '" + eadd + "')";
        // Alternate way !!
        String query = String.format("insert into employee1 values(%d,'%s',%f,'%s')", eno,ename,esal,eadd);

        // String query2 = "Delete from employee1 where eno = 78";
        st.executeUpdate(query);
        System.out.println("Data Inserted Successfully !");
        // con.commit();
        con.close();
    }
}
