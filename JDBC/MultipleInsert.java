import java.sql.*;
import java.util.Scanner;

public class MultipleInsert {
    public static void main(String[] args) throws  Exception{
        Scanner input = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");

        Statement st = con.createStatement();
        while (true) {
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

            String query = String.format("insert into employee1 values(%d,'%s',%f,'%s')", eno,ename,esal,eadd);
            st.executeUpdate(query);

            System.out.println("Data Inserted Successfully !");
            System.out.println("Do you want to continue ?, type 'exit' to exit : ");
            String reinsert = input.next();

            if (reinsert.equalsIgnoreCase("exit"))
                break;
            }
        con.close();
    }
}
