package edu.pms.z2h_old.myclimbers.obj;

public class Checkin {
	private long id;
	private String time;
	private String checkPoint;
	
	
	public Checkin(String checkPoint,String time) {
		super();
		this.time = time;
		this.checkPoint = checkPoint;
	}
	
	
	public Checkin(long id, String checkPoint,String time) {
		super();
		this.id = id;
		this.time = time;
		this.checkPoint = checkPoint;
	}


	public Checkin() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
