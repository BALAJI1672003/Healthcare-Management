import java.sql.*;
public class Connection_Establishment {
       public static Connection getConnect() throws Exception {
		   Connection con=null;
		   try {
			   
			   //Load Drive Class
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   //connect to database
			   con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/Healthcare","root","rot");
			   
		   }
		   catch(Exception e) {
			   System.out.println(e);
		   }
		   return con;
	   }
	   
	   
}
