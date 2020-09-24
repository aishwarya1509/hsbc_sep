package com.Exam.dao;


import java.util.ArrayList;
import java.util.List;

import com.Exam.entity.ExamApparel;
import com.Exam.entity.ExamElectronics;
import com.Exam.entity.ExamFoodItem;
import com.Exam.utility.ExamException;


public class ExamDao implements ExamDaoInterface{
	private List<ExamFoodItem> ll=null;
	private List<ExamApparel> la=null;
	private List<ExamElectronics> le=null;

	public ExamDao() {
		ll=new ArrayList<ExamFoodItem>();
		la=new ArrayList<ExamApparel>();
		le=new ArrayList<ExamElectronics>();
		
	}
	

	public int insertInListDao1(ExamFoodItem ta) 
	{
		int i=0;
		ll.add(ta);
	
		
		if(ll.size()>0) {
			i=1;
		}
		
		return i;
		
	}
	
	public int insertInListDao2(ExamElectronics ta)
	{
		int i=0;
		le.add(ta);
	
		
		if(le.size()>0) {
			i=1;
		}
		
		return i;
		
	}
	
	
	public int insertInListDao3(ExamApparel ta) 
	{
		int i=0;
		la.add(ta);
	
		
		if(la.size()>0) {
			i=1;
		}
		
		return i;
		
	}


	@Override
	public List<ExamFoodItem> showlistDao1() throws ExamException {
		if(ll==null)
		{
			throw new ExamException("");
		}
		return ll;
	}


	@Override
	public List<ExamElectronics> showlistDao2() {
		return le;
	}


	@Override
	public List<ExamApparel> showlistDao3() {
		return la;
	}

}
