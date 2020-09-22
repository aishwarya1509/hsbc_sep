package com.skeletons.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.skeletons.telegram.entity.TelegramUser;

public class TelegramDao implements TelegramDaoInterface
{
	
	public int createProfileDAO(TelegramUser tu) throws Exception
	{
        int i=0;
       
        //load driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //create connection with database
        Connection con = DriverManager.getConnection("jdbc:derby:e:/newdb;create=true","aishwarya","aisha");
        
        PreparedStatement ps = con.prepareStatement("insert into telegramuser values(?,?,?,?)");
        ps.setString(1,tu.getName());
        ps.setString(2,tu.getPassword());
        ps.setString(3,tu.getEmail());
        ps.setString(4,tu.getAddress());
        
        i = ps.executeUpdate();
       
        return i;
        
       }


	@Override
	public void deleteData() {
		System.out.println("Data Deleted");
		
	}


}
