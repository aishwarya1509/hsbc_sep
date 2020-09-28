package com.webwhatsapp.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webwhatsapp.entity.WhatsappUser;


public class DaoLayer implements DaoInterface {
	
	private Connection con;
	public DaoLayer() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			 con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public int createProfileDAO(WhatsappUser fu) throws IOException  {
        int i=0;
        try {
   
        PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?,?)");
        ps.setString(1,fu.getName());
        ps.setString(2,fu.getPassword());
        ps.setString(3,fu.getEmail());
        ps.setString(4,fu.getAddress());
        
        i = ps.executeUpdate();
        }
        
        catch(SQLException e1)
        {
        e1.printStackTrace();
        }
        finally
        {
        	try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        }
        
        return i;
        
       }

	@Override
	public boolean loginProfile(WhatsappUser iu) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=? and password=?");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
							
			
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}

	@Override
	public List<WhatsappUser> friendlistdao(WhatsappUser iu) {
		List<WhatsappUser> ll=new ArrayList<WhatsappUser>();
		WhatsappUser f=new WhatsappUser();
		f.setName("Akshata");
		f.setAddress("Mumbai");
		
		WhatsappUser f1=new WhatsappUser();
		f1.setName("Shriya");
		f1.setAddress("Canada");
		
		ll.add(f);
		ll.add(f1);
		
		return ll;
	}

	
}
