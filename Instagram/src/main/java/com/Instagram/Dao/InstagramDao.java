/**
 * 
 */
package com.Instagram.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Instagram.Entity.InstagramUser;

/**
 * @author Aishwarya
 *
 */
@Repository
public class InstagramDao {

	
	public List<InstagramUser> viewallProfileDao() {
		
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
   	 Connection con=null;
   	 try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
		PreparedStatement ps=con.prepareStatement("select * from facebookuser");
				
		ResultSet res=ps.executeQuery();
	
		
		while(res.next()) {
			InstagramUser uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
   	 }
   	 catch(ClassNotFoundException|SQLException e1)
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
	        
		return ll;
	}

	

	/**
	 * @param newUser
	 * @return
	 */
	public InstagramUser createProfileDao(InstagramUser newUser) {
		 Connection con=null;
		 int i=0;
	        try {
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        
	        con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
	        
	        PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?,?)");
	        ps.setString(1,newUser.getName());
	        ps.setString(2,newUser.getPassword());
	        ps.setString(3,newUser.getEmail());
	        ps.setString(4,newUser.getAddress());
	        
	        i = ps.executeUpdate();
	        }
	        
	        catch(ClassNotFoundException|SQLException e1)
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
	        
	        return newUser;
	}



	/**
	 * @param name
	 */
	public void deleteProfileDao(String name) {
		int i=0;
	    Connection con=null;
	    try {
        
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
         con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
        
        PreparedStatement ps = con.prepareStatement("delete from facebookuser where name=?");
        ps.setString(1, name);
        
      
        i = ps.executeUpdate();
	    }
	    catch(ClassNotFoundException|SQLException e1)
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
        System.out.println("Deleted  "+i);
		
	}


	/**
	 * @param editingUser
	 * @return 
	 */
	public InstagramUser editProfileDao(InstagramUser editingUser) {
		int i=0;
	    Connection con=null;
        try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
        con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
        PreparedStatement ps = con.prepareStatement("update facebookuser set email=?,address=? where name=? ");
        
        ps.setString(1,editingUser.getEmail());
        ps.setString(2,editingUser.getAddress());
        ps.setString(3,editingUser.getName());
      
        i = ps.executeUpdate();
        
        }
        catch(ClassNotFoundException|SQLException e1)
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
        
       System.out.print("Edited"+i);
	
       return editingUser;
		
	}
	
}
