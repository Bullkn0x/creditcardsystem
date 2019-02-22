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
					break;
				case 6:
					break;
				case 7:
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
}





