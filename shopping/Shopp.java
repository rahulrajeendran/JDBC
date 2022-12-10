package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Shopp {
	String url="jdbc:mysql://localhost:3306/shop";
	String password="childofprophecy@7";
	Scanner ss=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Shopp obj1=new Shopp();
		int n;
		do {
			System.out.println(" 1.Log in \n 2.Exit");
			System.out.println("Enter your choise");
		    n=sc.nextInt();
		    switch(n) {
		    case 1:
		    	obj1.login();
		    	break;
		    	
		    case 2:
		    	n=0;
		    	break;
		    }
		}while(n!=0);
	}
	
	void login() throws Exception{
		Shopp obj=new Shopp();
		Connection con=DriverManager.getConnection(url,"root",password);
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
			int n;
			do {
				System.out.println(" 1.Add item \n 2.Exit");
				System.out.println("Enter your choise");
			    n=ss.nextInt();
			    switch(n) {
			    case 1:
			    	obj.add();
			    	break;
			    	
			    case 2:
			    	n=0;
			    	break;
			    }
			}while(n!=0);
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	void add() throws Exception{
		Connection con=DriverManager.getConnection(url,"root",password);
		System.out.println("Enter item name : ");
		String uname=ss.next();
		System.out.println("Enter quantity : ");
		int pass=ss.nextInt();
		Statement st=con.createStatement();
		PreparedStatement ps = con.prepareStatement("insert into Items(name,Quantity)values(?,?);");
		ps.setString(1, uname);
		ps.setInt(2, pass);
		ps.execute();
		System.out.println("Item Added.\n");
	}
}
