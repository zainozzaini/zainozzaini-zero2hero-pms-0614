package com.example.hellopms;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Human{
	private String firstName;
	private String lastName;
	private String sex;
	private String dob;
	private int age;
	
	
	private MobilePhone mobilePhone;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
	    SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yy");
	    Date dNow = new Date( );
	  
		Date dobDate = new Date(dob);
		long age =dNow.getTime() -dobDate.getTime();

		return (int) age/1000;
	}
	
	public MobilePhone getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(MobilePhone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	

}
