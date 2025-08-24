// Creating of table using java Program !

import java.sql.*;
public class CreateTableDemo{
	public static void main(String[] args)throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
		Statement st = con.createStatement();
		st.executeUpdate("Create table employee1(eno number, ename varchar2(10), esal number(10,2), eadd varchar2(20))");
		System.out.println("Table Created Successfully!");
		con.close();
	}
}