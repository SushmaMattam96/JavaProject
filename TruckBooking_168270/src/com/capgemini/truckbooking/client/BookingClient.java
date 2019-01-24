package com.capgemini.truckbooking.client;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.truckbooking.Exception.TSException;
import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.service.ITruckService;
import com.capgemini.truckbooking.service.TruckService;




public class BookingClient {

	public static void main(String args[]) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scan = null;
		int choice = 0;
		ITruckService truckservice = null;
		
	

		boolean flag = false;
		do {
			scan = new Scanner(System.in);
			System.out.println("========BookTruck=========");
			System.out.println("1.Book Trucks");
			System.out.println("2.Exit");

			System.out.println("Enter your choice");

			try {
				choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					scan.nextLine();
					System.out.println("Enter the booking details");
					System.out.println("Enter the customer Id: ");
					String custid = scan.nextLine();
					

					List<TruckBean> trucklist = new ArrayList<TruckBean>();
					truckservice = new TruckService();

					try {
						trucklist = truckservice.retrieveTruckDetails();
						System.out.println(trucklist);
						if(trucklist.size()>0)
						{
							
							System.out
									.println(" TruckId      TruckType     Origin       Destination      Charges      AvaliableNos");
							for (TruckBean truckbean : trucklist) {
								System.out.println(truckbean.getTruckId()
										+ "  " + truckbean.getTruckType()
										+ "  " + truckbean.getOrigin()
										+ "     " + truckbean.getDestination()
										+ "  " + truckbean.getCharges()
										+ "    " + truckbean.getAvailableNos());
							}
						} else {
							System.out.println("The truck details not found");
						}
					} catch (TSException e) {
						System.out.println(e.getMessage());
					}

					System.out.println("Enter the truck id: ");
					int truckid = scan.nextInt();
					System.out.println("Enter the number of trucks: ");
					int nooftruck = scan.nextInt();
					System.out.println("Enter customer mobile number: ");
					long custmob = scan.nextLong();
					System.out.println("Enter the date : ");
					DateTimeFormatter datefom = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDateTime dateTime = LocalDateTime.now();
					/*LocalDateTime dateTime=scan.next();*/
					System.out.println(datefom.format(dateTime));
					
					BookingBean bookingdetails = new BookingBean();
					bookingdetails.setCustid(custid);
					bookingdetails.setTruckid(truckid);
					bookingdetails.setNoOfTrucks(nooftruck);
					bookingdetails.setCustMobile(custmob);
					bookingdetails.setDateofTransport(dateTime);
					
					try {
						boolean validateFlag =truckservice.validateFields(bookingdetails);
						if(validateFlag)
						{
							int records=truckservice.bookTrucks(bookingdetails);
							System.out.println("edjfdytf");
							System.out.println("Your booking details has been inserted:" + records);
						}
					}catch(TSException e)
						{
							System.out.println(e.getMessage());
						}
					break;
				case 2: 
				return ;
				
				default:
					flag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter ur input again");
					break;
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
			

		} 
			
		
}while (!flag);
}
}
