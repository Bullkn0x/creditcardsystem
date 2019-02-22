package dao;

import model.customer;
import resources.myQuries;

public class CustomerDao extends dbconnection_abstract {
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
