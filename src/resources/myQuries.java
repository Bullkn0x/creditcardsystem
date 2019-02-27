package resources;


public class myQuries{
	public final static String totalByType = "select sum(transaction_value), count(*)" +
											"from CDW_SAPP_CREDITCARD " +
											"where TRANSACTION_TYPE = ? " +
											"GROUP by TRANSACTION_TYPE";

    public final static String transactionsByZip= "SELECT CDW_SAPP_CREDITCARD.* FROM CDW_SAPP_CUSTOMER LEFT JOIN CDW_SAPP_CREDITCARD ON CDW_SAPP_CUSTOMER.CREDIT_CARD_NO = CDW_SAPP_CREDITCARD.CREDIT_CARD_NO WHERE CUST_ZIP= ? AND MONTH = ? AND YEAR = ? ORDER BY DAY" ;

     public final static String transactionsByType= "SELECT COUNT(TRANSACTION_VALUE) '# of Transactions', FORMAT(SUM(TRANSACTION_VALUE), 2) 'Transaction totals'FROM CDW_SAPP_CREDITCARD WHERE TRANSACTION_TYPE = ? GROUP BY TRANSACTION_TYPE;";

     public final static String transactionsByBranchState= "SELECT COUNT(TRANSACTION_VALUE) '# of Transactions', FORMAT(SUM(TRANSACTION_VALUE), 2) 'Transaction totals' FROM CDW_SAPP_CREDITCARD LEFT JOIN CDW_SAPP_BRANCH ON CDW_SAPP_BRANCH.BRANCH_CODE = CDW_SAPP_CREDITCARD.BRANCH_CODE WHERE BRANCH_STATE = ?;";

     public final static String checkAccountDetails ="SELECT FIRST_NAME 'First Name', LAST_NAME ' Last Name', CREDIT_CARD_NO 'Card Number', APT_NO 'Apt #', STREET_NAME 'Street Name', CUST_CITY 'City', CUST_STATE 'State', CUST_COUNTRY 'Country', CUST_ZIP 'Zipcode', CUST_PHONE 'Phone', CUST_EMAIL 'Email' FROM CDW_SAPP_CUSTOMER WHERE FIRST_NAME=? AND LAST_NAME=?  AND RIGHT(SSN, 4) = ?;";


     public final static String modifyAccountDetails  = "UPDATE CDW_SAPP_CUSTOMER SET %s = ? WHERE FIRST_NAME = ? AND LAST_NAME = ? AND RIGHT(SSN, 4) = ?;";



     public final static String generateBill  = "SELECT DAY 'Day of Month', CREDIT_CARD_NO 'Credit Card Number', FORMAT(TRANSACTION_VALUE, 2) 'Transaction Value', TRANSACTION_TYPE 'Type' FROM CDW_SAPP_CREDITCARD WHERE MONTH = ? and YEAR = ? AND CREDIT_CARD_NO = ? AND RIGHT(CUST_SSN, 4) = ? ORDER BY DAY ASC;";


public final static String transactionsBetweenDates = "SELECT CDW_SAPP_CREDITCARD.CREDIT_CARD_NO, CDW_SAPP_CREDITCARD.CUST_SSN, TRANSACTION_TYPE ' Transaction Type', FORMAT(TRANSACTION_VALUE, 2) 'Transaction Total', STR_TO_DATE(CONCAT(MONTH, '/', DAY, '/', YEAR), '%m/%d/%Y') AS 'DATEFORMAT' FROM CDW_SAPP_CREDITCARD LEFT JOIN CDW_SAPP_CUSTOMER ON CDW_SAPP_CUSTOMER.CREDIT_CARD_NO = CDW_SAPP_CREDITCARD.CREDIT_CARD_NO WHERE CDW_SAPP_CREDITCARD.CREDIT_CARD_NO = ? AND RIGHT(CUST_SSN, 4) = ? AND STR_TO_DATE(CONCAT(MONTH, '/', DAY, '/', YEAR), '%m/%d/%Y') BETWEEN ? AND ? ORDER BY DATEFORMAT DESC;";
}
