package com.cg.ma.presentation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.ma.dao.MobileDao;
import com.cg.ma.dao.MobileDaoImpl;
import com.cg.ma.exceptions.MAException;
import com.cg.ma.model.CustomerMobileDetails;
import com.cg.ma.service.Mobileservice;
import com.cg.ma.service.Mobileserviceimpl;

public class UIClass {
	public static void main(String args[]) {
		Scanner scan = null;
		int choice = 0;
		Mobileservice mobileservice=null;
		MobileDao mobiledao=null;
		boolean flag = false;
		do {

			scan = new Scanner(System.in);
			System.out.println("#############Mobile Application###############");
			System.out.println("1.Purchase Mobile");
			System.out.println("2.Diplay Quantity of Moblies");
			System.out.println("3.Deletion of MobileDetails");
			System.out.println("4.Search Mobile Based Price");

			System.out.println("Enter your Choice");

			try {

				choice = scan.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter Customer Details");
					System.out.println("Enter Customer Name");
					scan.nextLine();
					String name=scan.nextLine();
					System.out.println("Enter Email Id:");
					String emailid=scan.nextLine();
					System.out.println("Enter Mobile No:");
					String phoneno=scan.nextLine();
					System.out.println("Enter Mobile Id :");
					int mobileid=scan.nextInt();
					
					CustomerMobileDetails mobiledetails=new CustomerMobileDetails();
					mobiledetails.setCustomerName(name);
					mobiledetails.setMailid(emailid);
					mobiledetails.setPhoneNo(phoneno);
					mobiledetails.setMobileid(mobileid);
					
					mobileservice=new Mobileserviceimpl();
					try {
						boolean validateFlag =mobileservice.validateFields(mobiledetails);
						if(validateFlag)
						{
							int records=mobileservice.addpurchasedetails(mobiledetails);
							System.out.println("Your records has been inserted:" + records);
						}
					}catch(MAException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2:
					List<CustomerMobileDetails> list= new ArrayList<CustomerMobileDetails>();
					mobiledao=new MobileDaoImpl();
					try{
						list=mobiledao.viewmobilequantity();
						if(list.size()>0){
							System.out.println("MobileId       MobileName       MobilePrice       Quantity");
							for(CustomerMobileDetails mobiledetails2:list)
							{
								System.out.println(mobiledetails2.getMobileid() + "       " + mobiledetails2.getMobileName()
										+ "       " + mobiledetails2.getPrice() + "       " + mobiledetails2.getQuantity());
							}
						}
					}catch(MAException e)
					{
						System.err.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Enter Mobile Id :");
					int mobileid1=scan.nextInt();
					
					mobileservice=new Mobileserviceimpl();
					try{
						
						CustomerMobileDetails mobiledetails1=new CustomerMobileDetails();
						mobiledetails1.setMobileid(mobileid1);
						mobileservice.deletemobile(mobileid1);
						System.out.println("Record deleted");
					}catch (MAException e) {
						
						System.err.println(e.getMessage());
						
					}

					break;
				case 4:
					List<CustomerMobileDetails> list1= new ArrayList<CustomerMobileDetails>();
					Double lowerrange = null,upperRange=null;
					System.out.println("Enter the lower range : ");
					lowerrange=scan.nextDouble();
					System.out.println("Enter upperrange value");
					upperRange=scan.nextDouble();
					
					mobileservice=new Mobileserviceimpl();
					try {
						list1=mobileservice.getpricedetails(lowerrange,upperRange);
						if(list1.size()>0){
							System.out.println(" MobileName ");
							for(CustomerMobileDetails mobiledetails2:list1)
							{
								System.out.println(mobiledetails2.getMobileName());
							}
						}
						
						//System.out.println("The mobile in between price is" + mobile);
					} catch (MAException e) {
						System.err.println(e.getMessage());
					}

					break;
				
				default:
					flag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter ur input again");
					break;
					
				}

			} catch (InputMismatchException e) {
				System.err.println("Enter the Valid Choice from Above");
				System.out.println("Enter choice again:");

			}

		} while (!flag);

		scan.close(); 

	}
}