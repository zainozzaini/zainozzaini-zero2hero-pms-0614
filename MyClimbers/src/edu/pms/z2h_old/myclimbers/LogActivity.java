package edu.pms.z2h_old.myclimbers;

import edu.pms.z2h_old.myclimbers.obj.Checkin;
import edu.pms.z2h_old.myclimbers.obj.DummyData;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LogActivity extends Activity{
	
	private String tag = getClass().getSimpleName();
	private DummyData dummyData = new DummyData();
	private ListView lvCheckin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		lvCheckin = (ListView) findViewById(R.id.lvCheckin);
		
		
		if(getIntent().getExtras()!= null){ //kalau  intent dari checkin
			//
			//getIntent().getStringExtra("checkin-time")----> ini adalah value masa dari main activity 
			Log.i(tag,getIntent().getStringExtra("checkin-time"));
			
			dummyData.getInstance().setCheckin(new Checkin("CHECK-1",getIntent().getStringExtra("checkin-time")));
			
		}
		
		
		generateListView();
	}
	
	
	
	private void generateListView(){

			    
			    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, dummyData.getInstance().getCheckinList());
			    lvCheckin.setAdapter(adapter);
	}

}





