package com.Exam.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.Exam.dao.ExamDaoInterface;
import com.Exam.entity.ExamApparel;
import com.Exam.entity.ExamElectronics;
import com.Exam.entity.ExamFoodItem;
import com.Exam.utility.DaoFactory;
import com.Exam.utility.ExamException;

	

public class ExamBusiness implements ExamBusinessInterface{
	
	private ExamDaoInterface ti;
	public ExamBusiness() {
		ti=DaoFactory.createObject("admin");
	}


public void insertinList(int i) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		if(i==1)
		{
			System.out.println("enter itemcode:");
			String 	itemcode = br.readLine();
			System.out.println("enter itemname:");
		    String name = br.readLine();
			System.out.println("enter unitprice");
			String	unitprice = br.readLine();
			System.out.println("enter Quantity");
			String quantity = br.readLine();
			
			System.out.println("enter DateofManufacture");
			String dom = br.readLine();
			System.out.println("enter DateofExpiry");
			String doe = br.readLine();
			System.out.println("enter if Vegetarian Yes/no");
			String veg = br.readLine();
			
			ExamFoodItem ta=new ExamFoodItem();	
			ta.setItem_code(itemcode);
			ta.setItem_name(name);
			ta.setUnit_price(unitprice);
			ta.setQuantity(quantity);
			ta.setDate_of_Expiry(doe);
			ta.setDate_of_Manufacture(dom);
			ta.setVegetarian(veg);
			
			int k=ti.insertInListDao1(ta);
			
			if(k>0)
				System.out.print("Data Inserted");
			else
				System.out.print("Data Not Created");
			}
		
		if(i==2)
		{
			System.out.println("enter itemcode:");
			String 	itemcode = br.readLine();
			System.out.println("enter itemname:");
		    String name = br.readLine();
			System.out.println("enter unitprice");
			String	unitprice = br.readLine();
			System.out.println("enter Quantity");
			String quantity = br.readLine();
			
			System.out.println("enter warranty");
			String warranty = br.readLine();
		
			ExamElectronics ta=new ExamElectronics();	
			ta.setItem_code(itemcode);
			ta.setItem_name(name);
			ta.setUnit_price(unitprice);
			ta.setQuantity(quantity);
			ta.setWarranty(warranty);
			
			int k=ti.insertInListDao2(ta);
			
			if(k>0)
				System.out.print("Data Inserted");
			else
				System.out.print("Data Not Created");
				
		}
		if(i==3)
		{
			System.out.println("enter itemcode:");
			String 	itemcode = br.readLine();
			System.out.println("enter itemname:");
		    String name = br.readLine();
			System.out.println("enter unitprice");
			String	unitprice = br.readLine();
			System.out.println("enter Quantity");
			String quantity = br.readLine();
			
			System.out.println("enter size");
			String size = br.readLine();
			
			System.out.println("enter material");
			String material = br.readLine();
		
			ExamApparel ta=new ExamApparel();	
			ta.setItem_code(itemcode);
			ta.setItem_name(name);
			ta.setUnit_price(unitprice);
			ta.setQuantity(quantity);
			ta.setSize(size);
			ta.setMaterial(material);
			
			int k=ti.insertInListDao3(ta);
			
			if(k>0)
				System.out.print("Data Inserted");
			else
				System.out.print("Data Not Created");
		}
		

		
	}


@Override
public void Showlist() {
	
	 List<ExamFoodItem> listfood=null;
	try {
		listfood = ti.showlistDao1();
	} 
	
	catch (ExamException e) {
		System.out.print(e);
	}
	
	  if(listfood!=null)
		{
		  System.out.println("Search results:");
		  for(ExamFoodItem oo:listfood) 
		{
			System.out.println("Item code:  "+oo.getItem_code());
			System.out.println("Item Name:  "+oo.getItem_name());
			System.out.println("Quantity Sold:  "+oo.getQuantity());
			System.out.println("Vegetarian:  "+oo.getVegetarian());
		}
		} 
	  else
	  {
		  System.out.println("No result found:");
	  }
	  
	  List<ExamElectronics> listelec=ti.showlistDao2();
	  if(listelec!=null)
		{
		  System.out.println("Search results:");
		  for(ExamElectronics oo:listelec) 
		{
			   System.out.println("Item code:  "+oo.getItem_code());
				System.out.println("Item Name:  "+oo.getItem_name());
				System.out.println("Quantity sold:  "+oo.getQuantity());
				System.out.println("Warranty:  "+ oo.getWarranty());
		}
		} 
	  else
	  {
		  System.out.println("No result found:");
	  }
	  
	  List<ExamApparel> listapparel=ti.showlistDao3();
	  if(listapparel!=null)
		{
		  System.out.println("Search results:");
		  for(ExamApparel oo:listapparel) 
		{
			  System.out.println("Item code:  "+oo.getItem_code());
				System.out.println("Item Name:  "+oo.getItem_name());
				System.out.println("Quantity:  "+oo.getQuantity());
				System.out.println("Size:  "+ oo.getSize());
				System.out.println("Material:  "+oo.getMaterial());
		}
		} 
	  else
	  {
		  System.out.println("No result found:");
	  }
	 	  

}	

}
