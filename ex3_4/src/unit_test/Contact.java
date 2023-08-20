package src.unit_test;

public class Contact implements Comparable<Contact> {

	private String name;
	private String surname;
	private long number;
	private String address;
	
	private int priority;

	public Contact(int priority){
		name = "/";
		surname = "/";
		number = -1;
		address = "/";
		this.priority = priority;
	}

	public Contact(String name, String surname, long number, String address, int priority){
		this.name = name;
		this.surname = surname;
		this.number = number;
		this.address = address;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "[" + name + " " + surname + ", Tel: " + number + " @: " + address + " (" + priority + ")" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + (int) (number ^ (number >>> 32));
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof Contact){
			Contact c = (Contact)obj;
			return c.number == this.number && c.name.equalsIgnoreCase(this.name) && c.surname.equalsIgnoreCase(this.surname) && c.address.equalsIgnoreCase(this.address);
		} else 
			return false;
			
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public long getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	/** @return A positive number if the priority of arg0 is numerically higher of the caller one. */
	public int compareTo(Contact arg0) {
		if(this == arg0) 
			return 0;
		Contact c = (Contact)arg0;
		return (priority == c.priority) ? 0 : priority - c.priority;
	}
}