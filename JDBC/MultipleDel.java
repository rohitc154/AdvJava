import java.sql.*;
import java.io.*;
import java.util.*;

public class MultipleDel{
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");

		Statement st = con.createStatement();
		
		while(true){
			System.out.println("Enter Employee Id to delete : ");
			int id = input.nextInt();
			String query = "Delete from employee1 where eno="+id;
			int rs = st.executeUpdate(query);
			System.out.println(rs);
			if(rs != 0)
				System.out.println("Recorded deleted Successfully!");
			else
				System.out.println("Record Not Found!");
			System.out.println("Want to delete another record?(yes/no)");
			String option = input.next();
			if (option.equalsIgnoreCase("no"))
				break;
		}
		con.close();
	}
}
		
