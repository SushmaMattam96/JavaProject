package com.cg.ma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.cg.ma.dao.MobileDao;
import com.cg.ma.dao.MobileDaoImpl;
import com.cg.ma.exceptions.MAException;
import com.cg.ma.model.CustomerMobileDetails;

public class Mobileserviceimpl implements Mobileservice {
	List<String> list = new ArrayList<>();
	MobileDao mobiledao = new MobileDaoImpl();

	@Override
	public boolean validateFields(CustomerMobileDetails mobiledetails)
			throws MAException {
		boolean validateflag = false;
		if (!checkname(mobiledetails.getCustomerName())) {
			list.add("Name must start with Capital letter and it should contain atleast 5-6 charcters");
		}
		if (!checkemailid(mobiledetails.getMailid())) {
			list.add("Should contain variables and numbers also followed by @ expression ");
		}
		if (!checkmobileno(mobiledetails.getPhoneNo())) {
			list.add("Should contain 10 numbers and can start with 6|7|8|9 ");
		}
		if (mobiledao.verifyquantity(mobiledetails.getMobileid())) {
			list.add("Mobile id doesn't exits ");
		}
		if(list.size()>0)
		{
			System.out.println(list);
		}
		else
		{
			validateflag=true;
		
		}
		return validateflag;
		
	}

	private boolean checkname(String customerName) {
		String nameRegx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegx, customerName);
	}

	private boolean checkemailid(String mailid) {
		String mailRegx = "[a-zA-Z0-9]*@[A-Za-z]*\\.[a-zA-Z]*";
		return Pattern.matches(mailRegx, mailid);
	}

	private boolean checkmobileno(String phoneNo) {
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(phoneNo));
	}


	@Override
	public int addpurchasedetails(CustomerMobileDetails mobiledetails) throws MAException {

		return mobiledao.insertrecords(mobiledetails);
	}

	@Override
	public List<CustomerMobileDetails> getpricedetails(Double lowerrange, Double upperRange) throws MAException {
		
		return mobiledao.getpricedetails(lowerrange,upperRange);
	}

}
