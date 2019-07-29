package testJobApp.phonedb;

import java.io.Serializable;

public class PhoneRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int number;
	private String note;
	
	public PhoneRecord() {}
	
	public PhoneRecord(String name, int phone) {
		this.name = name;
		this.number = phone;		
	}
	
	public PhoneRecord(String name, int number, String note) {
		this.name = name;
		this.number = number;
		this.note = note;
	}
	
	public PhoneRecord(int id, String name, int number, String note) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.note = note;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int phone) {
		this.number = phone;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

}
