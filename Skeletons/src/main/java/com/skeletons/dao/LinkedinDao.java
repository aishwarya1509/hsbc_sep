package com.skeletons.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.skeletons.linkedin.entity.LinkedinUser;

public class LinkedinDao implements LinkedinDaoInterface {
	
	@Override
	public int createProfileDAO(LinkedinUser lu)throws Exception {
        int i=0;
        //load driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //create connection with database
        Connection con = DriverManager.getConnection("jdbc:derby:e:/newdb;create=true","aishwarya","aisha");
        
        PreparedStatement ps = con.prepareStatement("insert into linkedinuser values(?,?,?,?)");
        ps.setString(1,lu.getName());
        ps.setString(2,lu.getPassword());
        ps.setString(3,lu.getEmail());
        ps.setString(4,lu.getAddress());
        
        i = ps.executeUpdate();
       
        return i;
        
       }
       

	@Override
	public void deleteData() {
		System.out.println("Data Deleted");
		
	}

}
