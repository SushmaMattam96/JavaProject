package com.cg.ts.pesentation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.cg.ts.dao.TruckDao;
import com.cg.ts.exceptions.TSException;
import com.cg.ts.model.BookingBean;
import com.cg.ts.service.Truckservice;
import com.cg.ts.service.truckserviceimpl;

public class BookingClient {
	public static void main(String args[]) {
		Scanner scan = null;
		Truckservice truckservice = null;
		TruckDao truckdao = null;
		boolean flag = false;
		int Choice = 0;

		do {
			scan = new Scanner(System.in);
			System.out.println("==========Booking Truck===========");
			System.out.println("1.Book Truck");
			System.out.println("2.Exit");

			System.out.println("Enter your choice");

			try {
				Choice = scan.nextInt();

				switch (Choice) {
				case 1:
					System.out.println("Enter details of customer to book truck");
					System.out.println("Enter CustomerId :");
					String custid = scan.nextLine();
					scan.nextLine();
					System.out.println("Enter the truckid: ");
					int truckid = scan.nextInt();
					System.out.println("Enter number of trucks : ");
					int truckno = scan.nextInt();
					System.out.println("Enter customer Mobile Number : ");
					long mobileno = scan.nextLong();
					System.out.println("Enter the date : ");
					DateTimeFormatter datefom = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDateTime dateTime = LocalDateTime.now();
					System.out.println(datefom.format(dateTime));

					BookingBean bookingdetails = new BookingBean();
					bookingdetails.setCustid(custid);
					bookingdetails.setNooftrucks(truckno);
					bookingdetails.setCustmobile(mobileno);
					bookingdetails.setDateoftansport(dateTime);
					truckservice=new truckserviceimpl();
					try {
						boolean validateFlag =truckservice.validateFields(bookingdetails);
						if(validateFlag)
						{
							int records=truckservice.addbookingdetails(bookingdetails);
							System.out.println("Your booking details has been inserted:" + records);
						}
					}catch(TSException e) {
						System.err.println(e.getMessage());
					}
					break;
					

				}

			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		} while (!flag);

	}
}
