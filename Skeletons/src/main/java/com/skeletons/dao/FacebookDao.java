package com.skeletons.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skeletons.facebook.entity.FacebookUser;
import com.skeletons.facebook.utility.FacebookException;

public class FacebookDao implements FacebookDaoInterface {
	

	@Override
	public int createProfileDAO(FacebookUser fu) throws IOException  {
		
		int c=0;
		char input;
		File f1 = new File("e:/hsbc_file/facebookuser.txt");
		FileOutputStream out=new FileOutputStream(f1,true);
		
		
		String st= "Name:"+fu.getName()+" "+ "Email:" + fu.getEmail() +" "+ "Password:" +fu.getPassword() + " "+"Address:"+fu.getAddress() + "\n";
		 for(int i=0;i<st.length();i++)
		 {
			out.write(st.charAt(i)); 
		 }
		 out.close();
		 
		 FileInputStream in=new FileInputStream(f1);
		
			
			while(!((c=in.read())==-1))
			{
				input = (char)c;
				System.out.print(input);
			}
			
		in.close();
		
		 /*Connection con=null;
        int i=0;
        try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
        con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
        
        PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?,?)");
        ps.setString(1,fu.getName());
        ps.setString(2,fu.getPassword());
        ps.setString(3,fu.getEmail());
        ps.setString(4,fu.getAddress());
        
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
        
        return i;*/
		return 1;
        
       }

	@Override
	public FacebookUser viewProfileDao(FacebookUser fu)  {
		Connection con=null;
		FacebookUser fu1 = null;
		
		try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
         con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
        
        PreparedStatement ps = con.prepareStatement("select * from facebookuser where name=?");
        ps.setString(1, fu.getName());
        ResultSet res = ps.executeQuery();
        
        if(res.next())
        {
        	fu1=new FacebookUser();
        	fu1.setName(res.getString(1));
        	fu1.setPassword(res.getString(2));
        	fu1.setEmail(res.getString(3));
            fu1.setAddress(res.getString(4));

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
	        
        return fu1;
		
	}

	
	@Override
	public int editProfileDao(FacebookUser fu,int k ) {
		    int i=0;
		    Connection con=null;
	        try {
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        
	        con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
	        
	        if(k==1)
	        {
	        	  PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=? ");
	              ps.setString(1, fu.getEmail());
	        
	              ResultSet res = ps.executeQuery();
	             
	              if(res.next())
	              {
	              	
	              	fu.setName(res.getString(1));
	              	fu.setPassword(res.getString(2));
	              	fu.setEmail(res.getString(3));
	                fu.setAddress(res.getString(4));

	              }
	              
	             
	              
	              if(fu.getEmail()!=null)
	      		{
	            	System.out.println("Your Details:");
	      			System.out.println("Name :" + fu.getName());
	      			System.out.println("Password:"+ fu.getPassword());
	      			System.out.println("Email:"+ fu.getEmail());
	      			System.out.println("Address:"+fu.getAddress());
	      			i=1;
	      		}
	            else
	            {
	            	System.out.print("User Not found");
	            	i=0;
	            	
	            }
	         
	        }
	        
	        else
	        {
	        
	        PreparedStatement ps = con.prepareStatement("update facebookuser set name=?,password=?,address=? where email=? ");
	        
	        ps.setString(1,fu.getName());
	        ps.setString(2,fu.getPassword());
	        ps.setString(3,fu.getAddress());
	        ps.setString(4,fu.getEmail());
	        
	        i = ps.executeUpdate();
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
	        
	        return i;
		
	}

	@Override
	public int deleteProfileDao(FacebookUser fu) {
		    int i=0;
		    Connection con=null;
		    try {
	        
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        
	         con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
	        
	        PreparedStatement ps = con.prepareStatement("delete from facebookuser where name=?");
	        ps.setString(1, fu.getName());
	        
	      
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
	        
		    
	        return i;
	}

	@Override
	public List<FacebookUser> searchProfileDao(FacebookUser fu) throws FacebookException{
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		Connection con =null;
		   try {
		    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        
	       con = DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
	        
	        PreparedStatement ps = con.prepareStatement("select * from facebookuser where name=?");
	        ps.setString(1, fu.getName());
	        ResultSet res = ps.executeQuery();
	       
			while(res.next()) {
				FacebookUser uu=new FacebookUser();
				uu.setName(res.getString(1));
				uu.setPassword(res.getString(2));
				uu.setEmail(res.getString(3));
				uu.setAddress(res.getString(4));
				
				ll.add(uu);
			}
			if(ll.size()==0)
			{
				throw new FacebookException("");
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
	
     @Override
	public List<FacebookUser> viewallProfileDao(){
    	 List<FacebookUser> ll=new ArrayList<FacebookUser>();
    	 Connection con=null;
    	 try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/facebookuser;create=true","aishwarya","aisha");
		PreparedStatement ps=con.prepareStatement("select * from facebookuser");
				
		ResultSet res=ps.executeQuery();
		
		
		
		while(res.next()) {
			FacebookUser uu=new FacebookUser();
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

	@Override
	public Map<String, List<FacebookUser>> userdetailwithhistorydao() {
Map<String, List<FacebookUser>> maplist=new HashMap<String, List<FacebookUser>>();
		
		List<FacebookUser> l1=viewallProfileDao();
		List<FacebookUser> l2=viewallProfileDao();
		
		maplist.put("studentlist", l1);
		maplist.put("studentlist2", l2);
		
		return maplist;
	}

}
