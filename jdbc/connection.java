package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class connection {

	String url="jdbc:mysql://localhost:3306/ex1";
	String password="childofprophecy@7";
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int n; 
		connection obj=new connection();
		do {
			System.out.println(" 1.Log in \n 2.Sign up \n 3.Exit");
			System.out.println("Enter your choise");
		    n=sc.nextInt();
		    switch(n) {
		    case 1:
		    	obj.login();
		    	break;
		    	
		    case 2:
		    	obj.signup();
		    	break;
		    	
		    case 3:
		    	n=0;
		    	break;
		    }
		}while(n!=0);

	}
	void login() throws Exception{
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root",password);
//		java.sql.Connection con=null;
//		con=DriverManager.getConnection(url,"root",password);
		Scanner s2=new Scanner(System.in);
		System.out.println("Enter User name : ");
		String uname=s2.next();
		System.out.println("Enter Password : ");
		String pass=s2.next();
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery("select * from Admin");
		int flag=0;
		while(rs.next()) {
			if(uname.equals(rs.getString(1))&&pass.equals(rs.getString(2))) {
				flag=1;
			}
		}
		if(flag==1) {
			System.out.println("Success....");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	void signup() throws Exception{
		Connection con=DriverManager.getConnection(url,"root",password);
		Scanner s3=new Scanner(System.in);
		System.out.println("Enter User name : ");
		String uname=s3.next();
		System.out.println("Enter Password : ");
		String pass=s3.next();
		Statement st=con.createStatement();
		String s="insert into Admin values("+uname+","+pass+");";
		System.out.println(s);
		st.executeQuery(s);
		System.out.println("Account created.");
	}

}
