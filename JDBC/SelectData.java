import java.sql.*;
import java.io.*;
class SelectData{
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JustCode","code&coffee");
		Statement st = con.createStatement();
		boolean
		ResultSet rs = st.executeQuery("Select * from employee1");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
}
		con.close();
	}
}

