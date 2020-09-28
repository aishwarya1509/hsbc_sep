package com.webinsta.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webinsta.entity.InstaUser;


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
	public int createProfileDAO(InstaUser fu) throws IOException  {
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
	public boolean loginProfile(InstaUser iu) {
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
	public List<InstaUser> friendlistdao(InstaUser iu) {
		List<InstaUser> ll=new ArrayList<InstaUser>();
		InstaUser f=new InstaUser();
		f.setName("Shweta");
		f.setAddress("Pune");
		
		InstaUser f1=new InstaUser();
		f1.setName("Shriya");
		f1.setAddress("Mumbai");
		
		ll.add(f);
		ll.add(f1);
		
		return ll;
	}

	
}
