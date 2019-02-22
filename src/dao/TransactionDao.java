package dao;

import java.util.ArrayList;
import java.util.List;

import model.customer;
import model.transaction;
import resources.myQuries;

public class TransactionDao extends dbconnection_abstract {
	
	public List<transaction> gettotalbyZip(int zip, int month ,int year) throws Exception {
		
		myconnection();
		ps = con.prepareStatement(myQuries.transactionsByZip);
		ps.setInt(1, zip);
		ps.setInt(2, month);
		ps.setInt(3, year);
		rs = ps.executeQuery();
		List<transaction> list= new ArrayList<transaction>();
		while(rs.next()) {
			transaction t = new transaction();
			t.setID(rs.getInt(1));
			t.setDay(rs.getInt(2));
			t.setMonth(rs.getInt(3));
			t.setYear(rs.getInt(4));
			t.setCardNo(rs.getString(5));
			t.setSsn(rs.getInt(6));
			t.setBranchCode(rs.getInt(7));
			t.setType(rs.getString(8));
			t.setValue(rs.getInt(9));
			list.add(t);
		}		
		return list;
	}
	public transaction gettotalbyType(String type) throws Exception {
		myconnection();
		ps = con.prepareStatement(myQuries.totalByType);
		ps.setString(1, type);
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next()) {
			t.setValue(rs.getInt(1));
			t.setCount(rs.getInt(2));
			return t;
		}		
		return null;
	}

	public transaction gettotalbyBranch(String state) throws Exception {
		myconnection();
		ps = con.prepareStatement(myQuries.transactionsByBranchState);
		ps.setString(1, state);
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next()) {
			t.setValue(rs.getInt(1));
			t.setCount(rs.getInt(2));
			return t;
		}		
		return null;
	}
	
	public customer checkaccountDetails(String firstname , String lastname, int ssn4) throws Exception {
		myconnection();
		ps = con.prepareStatement(myQuries.checkAccountDetails);
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setInt(3, ssn4);
		rs = ps.executeQuery();
		customer c = new customer();
		if(rs.next()) {
			c.setFirstName(rs.getString(1));
			c.setLastName(rs.getString(2));
			c.setCreditCardNo(rs.getString(3));
			c.setAptNo(rs.getInt(4));
			c.setCustStreetName(rs.getString(5));
			c.setCustCity(rs.getString(6));
			c.setCustState(rs.getString(7));
			c.setCustCountry(rs.getString(8));
			c.setCustZipcode(rs.getInt(9));
			c.setPhone(rs.getInt(10));
			c.setEmail(rs.getString(11));
			return c;
		}		
		return null;
	}
}