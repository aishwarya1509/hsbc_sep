package com.skeletons.facebook.utility;


import java.util.Comparator;

import com.skeletons.facebook.entity.FacebookUser;

public class SortBy_Address implements Comparator<FacebookUser>{

	@Override
	public int compare(FacebookUser f1, FacebookUser f2) {
		
		return f1.getAddress().compareTo(f2.getAddress());
	}


}