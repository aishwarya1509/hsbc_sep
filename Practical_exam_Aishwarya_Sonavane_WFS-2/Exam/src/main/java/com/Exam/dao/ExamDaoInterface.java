package com.Exam.dao;

import java.util.List;

import com.Exam.entity.ExamApparel;
import com.Exam.entity.ExamElectronics;
import com.Exam.entity.ExamFoodItem;
import com.Exam.utility.ExamException;


public interface ExamDaoInterface {
	public int insertInListDao1(ExamFoodItem ta) ;
	public int insertInListDao2(ExamElectronics ta);
	public int insertInListDao3(ExamApparel ta) ;
	public List<ExamFoodItem> showlistDao1() throws ExamException;
	public List<ExamElectronics> showlistDao2();
	public List<ExamApparel> showlistDao3();

}
