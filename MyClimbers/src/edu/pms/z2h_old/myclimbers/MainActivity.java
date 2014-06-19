package edu.pms.z2h_old.myclimbers;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends Activity {
	
	private String tag = getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ImageButton btnLog = (ImageButton) findViewById(R.id.btnLog);
		ImageButton btnCheckin = (ImageButton) findViewById(R.id.btnCheckin);
		ImageButton btnEmergency = (ImageButton) findViewById(R.id.btnEmergency);
		
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
		       
		    }
		});
		
		
		
		btnEmergency.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        Log.i(tag,"Emergency");
		       
		    }
		});
		
		
		
		

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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
