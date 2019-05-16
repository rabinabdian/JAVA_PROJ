package minimalExample;
public class Person
{
	public void sayHello() { System.out.println("Hello from Person"); }
	public void sayGoodbye() { System.out.println("Goodbye from Person"); }
	public Address address;
	public String name;
	public Person(String personname) { this.name = personname; 	}
	public Person() {
		System.out.println("Creating person");
	}
	public Address getAddress() { return address; } public void setAddress( Address value ) { address = value; }
	
}