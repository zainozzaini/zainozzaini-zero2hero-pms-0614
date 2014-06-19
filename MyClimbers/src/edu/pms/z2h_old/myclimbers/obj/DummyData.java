package edu.pms.z2h_old.myclimbers.obj;

import android.util.Log;

public class DummyData {
	
	private static DummyData instance;
	private Checkin checkin;
	private String[] checkinArray = new String[100];
	private String tag = getClass().getSimpleName();
	
	private int row = 0;
	
	public DummyData(){
		
	}
	
	
	
	public int getRow() {
		return row;
	}






	public String[] getCheckinArray() {
		return checkinArray;
	}



	public Checkin getCheckin() {
		return checkin;
	}


	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
		String checkPointWithTime = checkin.getCheckPoint() + "(" + checkin.getTime() +")";
		checkinArray[++row] = checkPointWithTime;
	
	}





	public static synchronized DummyData getInstance(){
		if (instance == null){
			instance = new DummyData();
		}
		
		return instance;
	}

}
