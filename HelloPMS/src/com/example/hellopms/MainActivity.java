package com.example.hellopms;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {
	
	private String tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Student std1 = new Student();
		std1.setFirstName("Amin");
		std1.setLastName("Bin Ahmad");
		std1.setSex("male");
		std1.setDob("04/10/1980");
		
		Log.i(tag, std1.getFirstName() + " " +std1.getLastName());
		Log.i(tag, "Age :" +std1.getAge());
		Log.i(tag, "Dob :" +std1.getDob());
		
		
		
		
		//Statement 3
		
		MobilePhone std1MobilePhone = new MobilePhone();
		std1MobilePhone.setType("Samsung S3");
		std1MobilePhone.setOs("Android");
		std1MobilePhone.setNumber("0193353132");
		
		std1.setMobilePhone(std1MobilePhone);
		
		Log.i(tag, "Std1 MobilePhone no:" +std1.getMobilePhone().getNumber());
		
		
		//Statement 4
		Student std2 = new Student();
		std2.setFirstName("Siti");
		std2.setLastName("Binti Ahmad");
		std2.setDob("03/12/00");
		
		
		Log.i(tag, std2.getFirstName() + " " +std2.getLastName());
		Log.i(tag, "Age :" +std2.getAge());
		Log.i(tag, "Dob :" +std2.getDob());
		
		
		Student[] allStudentInClass1 = {std1,std2};
		
		ClassRoom class1 = new ClassRoom(allStudentInClass1,3,"merah");
		Log.i(tag, "How many student in Class1:" +class1.getStudent().length);
		
		for(int i=0;i<class1.getStudent().length;i++){
			Log.i(tag, " student in Class1 :" +class1.getStudent()[i].getFirstName());
		}
		
		//How to use arrayList
		ArrayList<Student> studentsArrayList = new ArrayList<Student>();
		studentsArrayList.add(std1);
		studentsArrayList.add(std2);
		
		ClassRoom class2 =  new ClassRoom(studentsArrayList,3,"Biru");
		
		for(int i=0;i<class2.getStudentArrayList().size();i++){
			Log.i(tag, " student in Class1 using ArrayList:" +class2.getStudentArrayList().get(i).getFirstName());
			Log.i(tag, " student in Class1 using ArrayList:" +class2.getStudentArrayList().get(i).getType());
		}
		
		
		
		
		
	  
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
