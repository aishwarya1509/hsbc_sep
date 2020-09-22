package com.skeletons.facebook.utility;

public class FacebookException extends Exception{
	private String name;
    @Override
	public String toString()
	{
		return "User does not exist";
		
	}
	
    public FacebookException(String name)
    {
    	this.name = name;
    }
   
    public String uu()
    {
    	String nn=null;
    	if(name.length()<3)
    	{
    		nn="username should be more than 3 characters";
    	}
    	return nn;
    }
    
}
