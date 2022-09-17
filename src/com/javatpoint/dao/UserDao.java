package com.javatpoint.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.bean.User;
public class UserDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
		
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//con=DriverManager.getConnection("jdbc:sqlserver://;servername=DESKTOP-8AGRSCH\\SQLEXPRESS;databaseName=JDBCDataBase;useNTLMv2=true;integratedSecurity=true");
		//con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8AGRSCH\\SQLEXPRESS (DESKTOP-8AGRSCH\\RAMESH B);databaseName=JDBCDataBase;integratedSecurity=true");
		//con =DriverManager.getConnection("jdbc:sqlserver://;servername=DESKTOP-8AGRSCH\\\\SQLEXPRESS;databaseName=JDBCDataBase","DESKTOP-8AGRSCH\\\\RAMESH B","Ramesh@2005");
		
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int save(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into USER432NEW(name,password,email) values(?,?,?)");
		//ps.setInt(1,String.valueOf(u.getId()));
		ps.setString(1,u.getName());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getEmail());
		
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int update(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update USER432NEW set name=?,password=?,email=? where id=?");
		ps.setString(1,u.getName());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getEmail());
		ps.setInt(4,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int delete(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from USER432NEW where id=?");
		ps.setInt(1,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public static List<User> getAllRecords(){
	List<User> list=new ArrayList<User>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from USER432NEW");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static User getRecordById(int id){
	User u=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from USER432NEW where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}
}
}
