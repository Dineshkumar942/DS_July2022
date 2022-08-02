package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Connection con=makeConnection();
		
		insertStudentDetails(con);
		retrieveDetails(con);
		retrieveSingleStudnetDetail(con);
		updateStudent(con);
		deleteStudentDetails(con);
	}
	static char getGrade(int total) {
		int avg=total/3;
		if(avg>=90) {
			return 'A';
		}
		else if(avg>=80 && avg<89) {
			return 'B';
		}
		else if(avg>=70 && avg<79) {
			return 'C';
		}
		else if(avg>=60 && avg<69) {
			return 'D';
		}
		else if(avg>=50 && avg<59) {
			return 'E';
		}
		else if(avg>=40 && avg<49) {
			return 'G';
		}
		else {
			return 'F';
		}
	}
	static Connection makeConnection() {
		Connection con=null;
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	static void insertStudentDetails(Connection con) {
		Scanner scan=new Scanner(System.in);
		Scanner scan1=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		Scanner scan3=new Scanner(System.in);
		Scanner scan4=new Scanner(System.in);
		Scanner scan5=new Scanner(System.in);
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?)");
			System.out.println("Enter student Roll No : ");
			int roll=scan.nextInt();
			System.out.println("Enter Student Name: ");
			String name=scan1.nextLine();
			System.out.println("Enter Student BirthDate : ");
			String date=scan2.nextLine();
			System.out.println("Enter Student's Physics Marks");
			int phy=scan3.nextInt();
			System.out.println("Enter Student's Chemistry Marks");
			int chem=scan4.nextInt();
			System.out.println("Enter Student's Maths Marks");
			int math=scan5.nextInt();
			int total=chem+phy+math;
			char grade=getGrade(total);
			pst.setInt(1, roll);
			pst.setString(2, name);
			pst.setString(8, date);
			pst.setInt(3, phy);
			pst.setInt(4, chem);
			pst.setInt(5, math);
			pst.setInt(6, total);
			pst.setString(7, String.valueOf(grade));
			int rows=pst.executeUpdate();
			if(rows!=0) {
				System.out.println("Student Details inserted.....");
			}
			else {
				System.out.println("Unable to add Details.....");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		scan1.close();
		scan2.close();
		scan3.close();
		scan4.close();
		scan5.close();
	}
	static void retrieveDetails(Connection con) {
		try {
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("select * from STUDENT");
			while(rs.next()) {
				System.out.println("Roll No : "+rs.getInt(1)); 
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Date of birth : "+rs.getString(8)); 
				System.out.println("Physics : "+rs.getInt(3)); 
				System.out.println("Chemistry "+rs.getInt(4)); 
				System.out.println("Maths : "+rs.getInt(5)); 
				System.out.println("Total : "+rs.getInt(6));
				System.out.println("Grade : "+rs.getString(7));
				System.out.println("-------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void retrieveSingleStudnetDetail(Connection con) {
		System.out.println("Enter student Roll No : ");
		Scanner scan=new Scanner(System.in);
		int roll=scan.nextInt();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from STUDENT WHERE ROLLNO="+roll);
			if(rs.next()) {
				System.out.println("Roll No : "+rs.getInt(1)); 
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Date of birth : "+rs.getString(8)); 
				System.out.println("Physics : "+rs.getInt(3)); 
				System.out.println("Chemistry "+rs.getInt(4)); 
				System.out.println("Maths : "+rs.getInt(5)); 
				System.out.println("Total : "+rs.getInt(6));
				System.out.println("Grade : "+rs.getString(7));
			}
			else {
				System.out.println("Student doesn't exist....");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
	}
	static void updateStudent(Connection con) {
		Scanner sc=new Scanner(System.in);
		Scanner scan1=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		Scanner scan3=new Scanner(System.in);
		Scanner scan4=new Scanner(System.in);
		Scanner scan5=new Scanner(System.in);
		System.out.println("Enter Student Roll No to update : ");
		int roll=sc.nextInt();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from STUDENT WHERE ROLLNO="+roll);
			if(rs.next()) {
				PreparedStatement pst = con.prepareStatement("UPDATE STUDENT SET NAME=?,PHYSICS=?,CHEMISTRY=?,MATHS=?,TOTAL=?,GRADE=?,BIRTHDATE=? WHERE ROLLNO="+roll);
				System.out.println("Enter Student Name: ");
				String name=scan1.nextLine();
				System.out.println("Enter Student BirthDate : ");
				String date=scan2.nextLine();
				System.out.println("Enter Student's Physics Marks");
				int phy=scan3.nextInt();
				System.out.println("Enter Student's Chemistry Marks");
				int chem=scan4.nextInt();
				System.out.println("Enter Student's Maths Marks");
				int math=scan5.nextInt();
				int total=chem+phy+math;
				char grade=getGrade(total);
				pst.setString(1, name);
				pst.setString(7, date);
				pst.setInt(2, phy);
				pst.setInt(3, chem);
				pst.setInt(4, math);
				pst.setInt(5, total);
				pst.setString(6, String.valueOf(grade));
				int rows=pst.executeUpdate();
				if(rows!=0) {
					System.out.println("Student Details updated.....");
				}
				else {
					System.out.println("Unable to update Details.....");
				}
			}
			else {
				System.out.println("Student doesn't exist with the Roll No"+roll);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		scan1.close();
		scan2.close();
		scan3.close();
		scan4.close();
		scan5.close();
		
	}
	static void deleteStudentDetails(Connection con) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter student Roll No:");
		int roll=scan.nextInt();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from STUDENT WHERE ROLLNO="+roll);
			if(rs.next()) {
				PreparedStatement pst = con.prepareStatement("DELETE FROM STUDENT WHERE ROLLNO=?");
				pst.setInt(1, roll);
				pst.executeUpdate();
				System.out.println("Deleted....");
			}
			else {
				System.out.println("Student doesn't exist with the roll no"+roll);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		
		
	}

}
