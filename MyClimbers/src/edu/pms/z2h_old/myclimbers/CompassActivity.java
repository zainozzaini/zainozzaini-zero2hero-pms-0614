package edu.pms.z2h_old.myclimbers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CompassActivity extends Activity{
	private TextView txtRotate;
	private Button btnRotate;
	private LinearLayout linearCompass;
	private EditText editRotate;
	private ImageView imgCompass;
	
	private String tag = getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);
		
		btnRotate =  (Button) findViewById(R.id.btnRotate);
		txtRotate = (TextView) findViewById(R.id.txtRotate);
		linearCompass = (LinearLayout) findViewById(R.id.layoutCompass);
		editRotate  = (EditText) findViewById(R.id.editRotate);
		imgCompass = (ImageView)findViewById(R.id.imgCompass);
		
		
		
		
		
		
		
		btnRotate.setOnLongClickListener(new OnLongClickListener(){

			@Override
			public boolean onLongClick(View v) {
				Log.i(tag,editRotate.getText().toString());	
				Log.i(tag,txtRotate.getText().toString());	
				txtRotate.setText(editRotate.getText().toString());
				Log.i(tag,txtRotate.getText().toString());
				
				//Demo 4 Task 
				try{
//					imgCompass.setRotation(Float.parseFloat(txtRotate.getText().toString()));
					rotateAnimation(Float.parseFloat(txtRotate.getText().toString()));
				}catch(Exception e){
					Toast.makeText(getApplication(), "Invalid Value", Toast.LENGTH_LONG).show();
				}
				
				
				
				
				return false;
			}});


	}
	
	
	private void rotateAnimation(float currentRotation){
		RotateAnimation anim = new RotateAnimation(0f, currentRotation,imgCompass.getWidth()/2, imgCompass.getHeight()/2);
		anim.setInterpolator(new LinearInterpolator());
		anim.setRepeatCount(0);
		anim.setDuration(1500);
		anim.setFillAfter(true);

		// Start animating the image
		imgCompass.startAnimation(anim);

		
		
	}
	
	
	

}
