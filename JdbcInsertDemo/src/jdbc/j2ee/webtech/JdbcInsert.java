package jdbc.j2ee.webtech;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcInsert {
	
	public static void main(String[] args) throws Exception 
 {
		
	  // v_* --> program variable, ui_* --> user input variable, p_* --> parameter variable

      //String v_name = "Disha";  -- it's hardcoded in sql insert stmt
		String v_email ="disha@gmail.com";
		String v_city = "Kanpur";
	  //String v_edu ="mca"; -- it's handled using Scanner input read	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1: Driver load and register successful");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","april22");
		System.out.println("Step 2: Connection created successful");
				
		PreparedStatement ps = con.prepareStatement("insert into register(fname, email, city, edu) values('Disha','"+v_email+"', ?, ?)");
		ps.setString(1, v_city);
		
		System.out.println("Enter your Educational Degree -> ");
		Scanner sc = new Scanner(System.in);			
		String ui_edu = sc.nextLine();
		
		ps.setString(2, ui_edu);

		System.out.println("Step 3: Statement Prepared Success");
		
		int val = ps.executeUpdate();
		if (val==1) 
			System.out.println(val+" Step 4: Statement Executiond successful");
		
		//con.close();
		 
 }

}
