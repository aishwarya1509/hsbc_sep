package com.Exam.utility;

import com.Exam.business.ExamBusiness;
import com.Exam.business.ExamBusinessInterface;

public class ControllerFactory {
public ControllerFactory() {
		
	}

	public static ExamBusinessInterface createObject(String nn) {
		// TODO Auto-generated method stub
		ExamBusinessInterface di=null;
		if(nn.equals("adminservice")) {
			di=new ExamBusiness();
		}
		return di;
	}
	
}
