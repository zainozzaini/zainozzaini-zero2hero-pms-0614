package com.example.hellopms;

public class MobilePhone implements MobilePhoneCriteria{
	
	private String type;
	private String os;
	private String number;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public void ringtone() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void duration() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
