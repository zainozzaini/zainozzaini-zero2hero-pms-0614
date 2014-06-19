package edu.pms.z2h_old.myclimbers.obj;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class DummyData {
	
	private static DummyData instance;
	private Checkin checkin;
	private List<String> checkinList = new ArrayList<String>();
	private String tag = getClass().getSimpleName();
	

	
	public DummyData(){
		
	}
	
	
	

	public List<String> getCheckinList() {
		return checkinList;
	}




	public Checkin getCheckin() {
		return checkin;
	}


	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
		String checkPointWithTime = checkin.getCheckPoint() + "(" + checkin.getTime() +")";
		checkinList.add(checkPointWithTime);
	
	
	}





	public static synchronized DummyData getInstance(){
		if (instance == null){
			instance = new DummyData();
		}
		
		return instance;
	}

}
