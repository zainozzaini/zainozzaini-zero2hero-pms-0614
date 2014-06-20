package edu.pms.z2h_old.myclimbers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;
import android.preference.PreferenceManager;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	
	private TextToSpeech tts;
	private String tag = getClass().getSimpleName();
	private ImageButton btnLog;
	private ImageButton btnCheckin;
	private ImageButton btnEmergency;
	
	private SharedPreferences sharedPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tts = new TextToSpeech(this, this);
		
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		btnLog = (ImageButton) findViewById(R.id.btnLog);
		btnCheckin = (ImageButton) findViewById(R.id.btnCheckin);
		btnEmergency = (ImageButton) findViewById(R.id.btnEmergency);
		
		btnLog.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        Log.i(tag,"Log");
		        Toast.makeText(getApplication(), "Log", Toast.LENGTH_LONG).show();
		        
		        Intent intent = new Intent(getApplication(), LogActivity.class);
		        startActivity(intent);
		       
		    }
		});
		
		
		
		btnCheckin.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        Log.i(tag,"Checkin");  
		        Intent i = new Intent(getApplication(),LogActivity.class);
		        i.putExtra("checkin-time", getCheckinTime());
		        i.putExtra("checkin-checkpoint", "CHECKPOINT 1");
		        startActivity(i);
		       
		    }
		});
		
		
		
		btnEmergency.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        Log.i(tag,"Emergency");
		        Log.i(tag,"Send sms -" +sharedPrefs.getBoolean("sendsms", true));
		        
		        if(sharedPrefs.getBoolean("sendsms", true)){
		        	//send sms
		        	 sendPanicSms(); //send panic sms
		        	 speakOut("We have send your panic sms");
		        }else{
		        	//just speakout
		        	 speakOut("Sorry you  are not activate your panic SMS.");
		        }
		       
		       
		       
		    }
		});
		
		
		
		

	}
	
	
	private void sendPanicSms(){
		//V1
//		Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//		sendIntent.putExtra("sms_body", "default content"); 
//		sendIntent.setType("vnd.android-dir/mms-sms");
//		startActivity(sendIntent);
		
		
		//v2 ref: http://android-er.blogspot.com/2011/03/send-sms-using-intentactionsendto.html
		
//		Uri uri = Uri.parse("smsto:" + "PUT YOUR NUMBER HERE");
//	    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//	    intent.putExtra("sms_body", "HELP ME -- message from MyClimbersApp ");  
//	    startActivity(intent);
		
		
		//v3 Ref:
		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage("PUT YOUR NUMBER HERE", null, "HELP ME -- message from MyClimbersApp", null, null);
	}
	
	private String getCheckinTime(){
		Date dNow = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		
		return df.format(dNow);
	}
	
	
	
	public void viewMountain(View view) {
		Log.i(tag,"Mountain");
		   Intent intent = new Intent(getApplication(), MountainActivity.class);
	        startActivity(intent);
	    
	}
	
	
	public void viewCompass(View view) {
		Log.i(tag,"Compass");
		   Intent intent = new Intent(getApplication(), CompassActivity.class);
	       startActivity(intent);
	    
	}
	
	
	
	
	
	
	
	
	//-----------------Let this this block below----------------------//

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
			Log.i(tag,"Settings");
			
			Intent i = new Intent(this,SettingsActivity.class);
			startActivity(i);
			
			return true;
		}
		
		if (id == R.id.action_about) {
			Log.i(tag,"About");
			
			Intent i = new Intent(this,AboutActivity.class);
			startActivity(i);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
			 
            int result = tts.setLanguage(Locale.US);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }
              
            
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
	}
	
	private void speakOut(String msg){
		tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
	}
	
	
	
	
	 @Override
	    public void onDestroy() {
	        // Don't forget to shutdown tts!
	        if (tts != null) {
	            tts.stop();
	            tts.shutdown();
	        }
	        super.onDestroy();
	    }

	
}
