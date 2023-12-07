package com.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.detailsBean;
import com.mvc.connection.DatabaseConnection;

public class detDAO {
	
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	int detID, qty;
	double price;
	String name, phone, email, delivery, message;
	Date date;
	
	public void add(detailsBean db) {
		//retrieving values from the details Bean
	       
        String name = db.getName();
        String phone = db.getPhone();
        String email = db.getEmail();
        int qty = db.getQty();
        String delivery = db.getDelivery();
        String message = db.getMessage();
        double price = db.getPrice();
        Date date = db.getDate();  
        
        try {
        	con = DatabaseConnection.getConnection();
        	// create statement
        	ps = con.prepareStatement("insert into message(name, phone, email, date, price, qty, delivery, message) values(?,?,?,?,?,?,?,?)");
        	ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setDate(4, date);
            ps.setDouble(5, price);
            ps.setInt(6, qty);
            ps.setString(7, delivery);
            ps.setString(8, message);
            
            ps.executeUpdate();
            con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	//get all details
		public static List<detailsBean> getAll() { 
			List<detailsBean> dets = new ArrayList<detailsBean>(); 
			try { 
				//call getConnection() method
				con = DatabaseConnection.getConnection();
				//3. create statement
				stmt = con.createStatement(); 
				//4. execute query
				rs = stmt.executeQuery("select * from message order by detailsID");

				while (rs.next()) { 
					detailsBean db = new detailsBean();
					db.setDetailsID(rs.getInt("detailsID"));	  
					db.setName(rs.getString("name"));
					db.setPrice(rs.getDouble("price"));
					db.setPhone(rs.getString("phone"));
					db.setEmail(rs.getString("email"));
					db.setDate(rs.getDate("date"));
					db.setPrice(rs.getDouble("price"));
					db.setQty(rs.getInt("qty"));
				    db.setDelivery(rs.getString("delivery"));
					db.setMessage(rs.getString("message"));
					dets.add(db);

				} 
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return dets; 
		}
		
		//update details
		public void editDetails(detailsBean db) {

			detID = db.getDetailsID();
			name = db.getName();
			phone = db.getPhone();
			email = db.getEmail();
			date = db.getDate();
			qty = db.getQty();
			price = db.getPrice();
			delivery = db.getDelivery();
			message = db.getMessage();
			
			try {
				//call getConnection() method  
				con = DatabaseConnection.getConnection();
				//3. create statement  
				ps=con.prepareStatement("update message set name=?, phone=?, email=?, date=?, price=?, qty=?, delivery=?, message=? where detailsID=?"); 		  
				ps.setString(1,name);//1 specifies the first parameter in the query i.e. name
				ps.setString(2,phone);		
				ps.setString(3,email);
				ps.setDate(4,date);
				ps.setDouble(5,price);
				ps.setInt(6,qty);			
				ps.setString(7,delivery);				
				ps.setString(8,message);
				ps.setInt(9, detID);
				
				//4. execute query
				ps.executeUpdate();

				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			
			}
		}
		
		//delete details
				public void deleteDetails(int detID) {
					try {
						//call getConnection() method 
						con = DatabaseConnection.getConnection();
						//3. create statement 
						ps = con.prepareStatement("delete from message where detailsID=?");
						ps.setInt(1, detID);
						//4. execute query
						ps.executeUpdate();
						//5. close connection
						con.close();
					
					}catch(Exception e) {
						e.printStackTrace();
					
					}
				}
		
		//get details by Id
		public static detailsBean getDetailsById(int detID) {
			detailsBean db = new detailsBean();
			try {
				//call getConnection() method
				con = DatabaseConnection.getConnection();
				//3. create statement
				ps = con.prepareStatement("select * from message where detailsID=?");
				ps.setInt(1, detID);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {	            
					db.setDetailsID(rs.getInt("detailsID"));
					db.setName(rs.getString("name"));
					db.setPhone(rs.getString("phone"));
					db.setEmail(rs.getString("email"));
					db.setDate(rs.getDate("date"));
					db.setPrice(rs.getDouble("price"));
					db.setQty(rs.getInt("qty"));
					db.setDelivery(rs.getString("delivery"));
					db.setMessage(rs.getString("message"));

					//db.setSid(rs.getInt("sid"));
				}
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}

			return db;
		}
		

}
