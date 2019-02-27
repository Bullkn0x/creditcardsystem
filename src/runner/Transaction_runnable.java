package runner;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dao.CustomerDao;
import dao.TransactionDao;
import model.customer;
import model.transaction;
import resources.myQuries;

public class Transaction_runnable {
	public void getTotalByType() throws Exception {	
		Scanner sc = new Scanner(System.in);
		Integer choice= 0;
		while (choice !=8) {
			try{
				menu();

				choice=sc.nextInt();
				switch(choice) {
				case 1:
					TransactionDao td1 = new TransactionDao();
					sc.nextLine();
					System.out.print("\nEnter a Zipcode: ");
					int scanzip= sc.nextInt();
					System.out.print("\nEnter a Month:");
					int scanmonth= sc.nextInt();
					System.out.print("\nEnter a Year:");
					int scanyear= sc.nextInt();
					List<transaction> list = td1.gettotalbyZip(scanzip, scanmonth, scanyear);
					String format1 = "%-15s %-12s %-5s %-4s %-5s %-13s %-17s %-16s %-12s\n";
					System.out.format (format1 ,"Tranasction ID", "Branch Code" , "Month", 
											   "Day", "Year", "Customer SSN", "Credit Card #" , 
											   "Transacton Value" , "Transaction Type" ); 
					for(transaction transaction: list) {
					System.out.format(format1 , transaction.getID(), transaction.getBranchCode(), transaction.getMonth(), 
												transaction.getDay(), transaction.getYear(), transaction.getSsn(), transaction.getCardNo(), 
												"$"+transaction.getValue(), transaction.getType());
					
					}
					
					break;
				case 2:
					TransactionDao td2 = new TransactionDao();
					sc.nextLine();
					System.out.println("Select a Category:");
					String category = sc.nextLine();
					transaction mytransaction2 = td2.gettotalbyType(category);
					String format2 = "%-12s %-12s \n";
					System.out.format (format2 , "Count" , "Total Value"); 
					System.out.format(format2 , mytransaction2.getCount(), mytransaction2.getValue() );
					break;
				case 3:
					TransactionDao td3 = new TransactionDao();
					sc.nextLine();
					System.out.print("\nPlease enter a State to find Branch History (Ex: NJ): ");
					String state = sc.nextLine();
					transaction mytransaction3 = td3.gettotalbyBranch(state);
					String format3= "";
					System.out.format ("\n%-12s %-12s \n", "# of Transactions" , "Total Transaction Value"); 
					System.out.format( "%-12s %-12s \n", mytransaction3.getCount(), "$" +mytransaction3.getValue() );
					System.out.println("\n\n");
					break;
				case 4:
					CustomerDao cd1 = new CustomerDao();
					sc.nextLine();
					System.out.print("\nPlease Enter your First Name:");
					String firstName= sc.nextLine();
					System.out.print("\nPlease Enter your Last Name:");
					String lastName= sc.nextLine();
					System.out.print("\nPlease Enter the last 4 of your SSN:");
					int ssn4= sc.nextInt();
					customer mycustomer1 = cd1.checkaccountDetails(firstName, lastName, ssn4);
					String format4 = "%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n"; 
					System.out.format(format4, "First Name", 
											   "Last Name", 
											   "Card Number", 
											   "Apt#", 
											   "Street Name", 
											   "City", 
											   "State", 
											   "Zipcode", 
											   "Country", 
											   "Phone", 
											   "Email");
					System.out.format(format4, mycustomer1.getFirstName(), 
											   mycustomer1.getLastName(),
											   mycustomer1.getCreditCardNo(),
											   mycustomer1.getAptNo(),
											   mycustomer1.getCustStreetName(),
											   mycustomer1.getCustCity(),
											   mycustomer1.getCustState(),
											   mycustomer1.getCustZipcode(),
											   mycustomer1.getCustCountry(),
											   mycustomer1.getPhone(),
											   mycustomer1.getEmail());
					break;
				case 5:
					CustomerDao cd5 = new CustomerDao();
					sc.nextLine();
					System.out.print("\nPlease Enter your First Name: ");
					String firstName5= sc.nextLine();
					System.out.print("\nPlease Enter your Last Name: ");
					String lastName5= sc.nextLine();
					System.out.print("\nPlease Enter the last 4 of your SSN: ");
					int ssn5= sc.nextInt();
					System.out.println("\nCurrent Credentials for Account:\n");
					customer mycustomer5 = cd5.checkaccountDetails(firstName5, lastName5, ssn5);
					String format5 = "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n "
								   + "\t%-20s %-15s\n ";
					System.out.format(format5,  "(1)  First Name:", mycustomer5.getFirstName(), 
												"(2)  Last Name:", mycustomer5.getLastName(),
												"(3)  Card Number:",  mycustomer5.getCreditCardNo(),
												"(4)  Apt. Number:",  mycustomer5.getAptNo(),
												"(5)  Street Name:",  mycustomer5.getCustStreetName(),
												"(6)  City:",   mycustomer5.getCustCity(),
												"(7)  State:",  mycustomer5.getCustState(),
												"(8)  Zip Code:",  mycustomer5.getCustZipcode(),
												"(9)  Country:",  mycustomer5.getCustCountry(),
												"(10) Phone Number:",  mycustomer5.getPhone(),
												"(11) Email Address:",  mycustomer5.getEmail());
					System.out.print("\nSelect Number of field you would like to update: ");
					int fieldselect = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the Updated Field Value: ");
					String newvalue= sc.nextLine();
					String columnName = null;
					switch(fieldselect) {
					case 1:
						columnName="FIRST_NAME";
						break;
					case 2:
						columnName="LAST_NAME";
						break;
					case 3:
						columnName="CREDIT_CARD_NO";
						break;
					case 4:
						columnName="APT_NO";
						break;
					case 5:
						columnName="STREET_NAME";
						break;
					case 6:
						columnName="CUST_CITY";
						break;
					case 7:
						columnName="CUST_STATE";
						break;
					case 8:
						columnName="CUST_ZIP";
						break;
					case 9:
						columnName="CUST_COUNTRY";
						break;
					case 10:
						columnName="CUST_PHONE";
						break;
					case 11:
						columnName="CUST_EMAIL";
						break;
					}
					customer c5 = cd5.updateDetails(columnName, newvalue, firstName5, lastName5, ssn5);
					CustomerDao cd6 = new CustomerDao();
					customer mycustomer6=cd6.checkaccountDetails(firstName5, lastName5, ssn5);
					String format5a = "%-13s %-12s %-18s %-7s %-19s %-9s %-8s %-9s %-15s %-12s %-12s\n"; 
					System.out.format(format5a, "First Name", 
											   "Last Name", 
											   "Card Number", 
											   "Apt#", 
											   "Street Name", 
											   "City", 
											   "State", 
											   "Zipcode", 
											   "Country", 
											   "Phone", 
											   "Email");
					System.out.format(format5a, mycustomer6.getFirstName(), 
											   mycustomer6.getLastName(),
											   mycustomer6.getCreditCardNo(),
											   mycustomer6.getAptNo(),
											   mycustomer6.getCustStreetName(),
											   mycustomer6.getCustCity(),
											   mycustomer6.getCustState(),
											   mycustomer6.getCustZipcode(),
											   mycustomer6.getCustCountry(),
											   mycustomer6.getPhone(),
											   mycustomer6.getEmail());
					
					break;
				case 6:
					TransactionDao td6 = new TransactionDao();
					sc.nextLine();
					System.out.print("\nPlease enter the last 4 digits of your social security number: ");
					int ssn = sc.nextInt();
					sc.nextLine();
					System.out.print("\nPlease enter a card number associated with your account: ");
					String cardnumber = sc.nextLine();
					System.out.print("\nType the month you are looking to generate a statement for: ");
					int monthbill = sc.nextInt();
					System.out.print("\nType the year you are looking to generate a statement for: ");
					int yearbill = sc.nextInt();
					List<transaction> listbill = td6.generatemonthlyStatement(cardnumber , ssn, monthbill, yearbill);
					String format6 = "%-5s %-20s %-18s  %-12s\n";
					System.out.format (format6, "Day", "Credit Card #" , 
											   "Transacton Value" , "Transaction Type" ); 
					for(transaction transaction: listbill) {
					System.out.format(format6 , transaction.getDay(), transaction.getCardNo(), "$"+transaction.getValue(), transaction.getType());
					}
					
					break;
				case 7:
					TransactionDao td7 = new TransactionDao();
					System.out.print("\nPlease enter the last 4 digits of your social security number: ");
					int ssn7 = sc.nextInt();
					sc.nextLine();
					System.out.print("\nPlease enter a card number associated with your account: ");
					String cardnumber7 = sc.nextLine();
					System.out.print("Enter First Date of Range You would like to see transactions for (Ex: MM/DD/YYYY): ");
					String date1 = datearrange(sc.nextLine() );
					System.out.print("Enter Second Date of Range You would like to see transactions for (Ex: MM/DD/YYYY): ");
					String date2 = datearrange(sc.nextLine() );
					List<transaction> listbetweendates =td7.transactionsbetweenDates(cardnumber7, ssn7, date1, date2);
					String format7 = "%-18s %-12s %-17s %-18s %-15s\n";
					System.out.format(format7, "Credit Card #", "SSN" , "Transaction Value", "Transaction Type", "Date");
					for (transaction  transaction: listbetweendates) {
						System.out.format(format7 , transaction.getCardNo(), transaction.getSsn(), "$"+transaction.getValue(), transaction.getType(),dateformat(transaction.getDate() ) );						
					}
					break;
				case 8:
					break;
				}
			}catch(InputMismatchException ex) {
				System.out.println("\nInvalid Input, Please Enter Int (1-8)\n");
				getTotalByType();
			}
		}

		sc.close();


}

	public static void menu() {
		System.out.println("Please enter transaction Type:");
		System.out.println("TRANSACTION DETAILS\n");
		System.out.println("	1. Display the transactions made by customers living"
				+ " in a given zip code for a given month and year. Order"
				+ " by day in descending order.");
		System.out.println("	2. To display the number and total values of transactions"
				+ " for a given type.");
		System.out.println("	3. To display the number and total values of transactions "
				+ "for branches in a given state.\n");
		System.out.println("CUSTOMER DETAILS\n");
		System.out.println("	4. To check the existing account details of a customer.");
		System.out.println("	5. To modify the existing account details of a customer");
		System.out.println("	6. To generate monthly bill for a credit card number for"
				+ " a given month and year.");
		System.out.println("	7. To display the transactions made by "
				+ "customer between two dates. Order by year, month, and day "
				+ "in descending order.");
		System.out.println("8. EXIT");
	
	}
	public static String datearrange(String date) {
		String[] datearray = date.split("/");
		String datenew= "";
		for (int i = 0 ;  i< datearray.length ; i++) {
			if (datearray[i].length() <2) {
				datearray[i]="0" +datearray[i];	
			}
			datenew=datearray[2]+datearray[0]+datearray[1];
		}
		return datenew;
	}
	
	public static String dateformat(String date) {
		String[] datearray = date.split("-");
		String dateformat="";
		for (int i = 0; i < datearray.length ; i++) {
			dateformat=datearray[1]+ "/" +datearray[2] + "/" + datearray[0];
		}
		
		return dateformat;
	}

}





