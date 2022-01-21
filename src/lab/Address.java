package lab;

public class Address {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	
	
	public Address(String addressLine1, String addressLine2, String city, String state, String zip) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}
	public String getLine1 () { return addressLine1; }
	public String getLine2 () { return addressLine2; }
	public String getCity () { return city; }
	public String getState () { return state; }
	public String getZip () { return zip; }
}
