package edu.pms.z2h_old.myclimbers.obj;

public class Checkin {
	private String time;
	private String checkPoint;
	
	
	public Checkin(String checkPoint,String time) {
		super();
		this.time = time;
		this.checkPoint = checkPoint;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}
	
	
	

}
