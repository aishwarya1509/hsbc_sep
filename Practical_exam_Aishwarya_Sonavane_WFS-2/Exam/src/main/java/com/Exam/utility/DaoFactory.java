package com.Exam.utility;

import com.Exam.dao.ExamDao;
import com.Exam.dao.ExamDaoInterface;

public class DaoFactory {
	public DaoFactory() {
		
	}

	public static ExamDaoInterface createObject(String nn) {
		// TODO Auto-generated method stub
		ExamDaoInterface di=null;
		if(nn.equals("admin")) {
			di=new ExamDao();
		}
		return di;
	}

}
