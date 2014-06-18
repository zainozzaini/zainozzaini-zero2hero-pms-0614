package com.example.hellopms;

import java.util.ArrayList;

public class ClassRoom {
	private Student[] student;
	private ArrayList<Student> studentArrayList;
	
	private int standard;
	private String name;
	
	
	public ClassRoom(Student[] student, int standard, String name) {
		super();
		this.student = student;
		this.standard = standard;
		this.name = name;
	}
	
	
	
	
	public ClassRoom(ArrayList<Student> studentArrayList, int standard,
			String name) {
		super();
		this.studentArrayList = studentArrayList;
		this.standard = standard;
		this.name = name;
	}




	public Student[] getStudent() {
		return student;
	}
	public void setStudent(Student[] student) {
		this.student = student;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student> getStudentArrayList() {
		return studentArrayList;
	}
	public void setStudentArrayList(ArrayList<Student> studentArrayList) {
		this.studentArrayList = studentArrayList;
	}
	
	

}
