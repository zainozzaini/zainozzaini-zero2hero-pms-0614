package edu.pms.z2h_old.myclimbers;

import java.util.ArrayList;
import java.util.List;

import edu.pms.z2h_old.myclimbers.db.CheckinDB;
import edu.pms.z2h_old.myclimbers.obj.Checkin;
import edu.pms.z2h_old.myclimbers.obj.DummyData;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LogActivity extends Activity{

	private String tag = getClass().getSimpleName();
	
//	private DummyData dummyData = new DummyData(); //use dummy data
	private CheckinDB checkinDB;
	
	private ListView lvCheckin;
	private int notifyId = 1337;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		lvCheckin = (ListView) findViewById(R.id.lvCheckin);
		
		checkinDB = new CheckinDB(this); 


		if(getIntent().getExtras()!= null){ //kalau  intent dari checkin -> dapatkan data dari intent
			//
			//getIntent().getStringExtra("checkin-time")----> ini adalah value masa dari main activity 
			Log.i(tag,getIntent().getStringExtra("checkin-time"));
			Log.i(tag,getIntent().getStringExtra("checkin-checkpoint"));

			//Use dummy data
//			dummyData.getInstance().setCheckin(new Checkin("CHECK-1",getIntent().getStringExtra("checkin-time")));
			
			//Use database ChekinDB
			Checkin chkIn= new Checkin(getIntent().getStringExtra("checkin-checkpoint"),getIntent().getStringExtra("checkin-time"));
			checkinDB.open();
			chkIn =checkinDB.createCheckin(chkIn); //this for new checkin with id in database
			checkinDB.close();
			
			

			//simple confirmation using offline-notification
			showNotification(getIntent().getStringExtra("checkin-time"));
		}


		generateListView();
	}



	private void generateListView(){
		
		//Use Dummy Data
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, dummyData.getInstance().getCheckinList());
//		lvCheckin.setAdapter(adapter);
		
		//Use Database CheckinDB
		List<String> allCheckPointAndTime = new ArrayList<String>();
		List<Checkin> allCheckinPointFromDB = new ArrayList<Checkin>();
		
		checkinDB.open();
		allCheckinPointFromDB = checkinDB.getAllCheckins();
		checkinDB.close();
		
		for(int i=0; i<allCheckinPointFromDB.size();i++){
			allCheckPointAndTime.add(
					allCheckinPointFromDB.get(i).getCheckPoint() +
					allCheckinPointFromDB.get(i).getTime());
		}
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1,allCheckPointAndTime);
		lvCheckin.setAdapter(adapter);
		
	}


	private void showNotification(String dateTime){
		NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(this)
		.setSmallIcon(R.drawable.ic_launcher)
		.setDefaults(Notification.DEFAULT_SOUND)
		.setContentTitle("MyClimbers")
		.setContentText("Congurate you have arrive at" +dateTime);
		// Creates an explicit intent for an Activity in your app
		Intent resultIntent = new Intent(this, LogActivity.class);

		// The stack builder object will contain an artificial back stack for the
		// started Activity.
		// This ensures that navigating backward from the Activity leads out of
		// your application to the Home screen.
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		// Adds the back stack for the Intent (but not the Intent itself)
		stackBuilder.addParentStack(MainActivity.class);
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent =
				stackBuilder.getPendingIntent(
						0,
						PendingIntent.FLAG_UPDATE_CURRENT
						);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager =
				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(notifyId, mBuilder.build());
	}

}





