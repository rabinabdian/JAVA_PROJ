package minimalExample;
public class Address
{
	public Address() {
		System.out.println("Creating Address");
	}

	public String city;
	public String getCity() { return city; } public void setCity(String value) { city = value; }
}