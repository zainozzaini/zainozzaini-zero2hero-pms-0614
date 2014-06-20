package edu.pms.z2h_old.myclimbers;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.util.Log;

public class SettingsActivity extends PreferenceActivity{
	
	private EditTextPreference prefName;
	private ListPreference prefSex;
	private CheckBoxPreference prefPanicSms;
	
	private String tag = getClass().getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);// we do not use this for preference activity
		
		addPreferencesFromResource(R.xml.settings);
		
		
		
		prefName = (EditTextPreference) findPreference("name");
		prefSex =(ListPreference) findPreference("sex");
		prefPanicSms = (CheckBoxPreference) findPreference("sendsms");
		
		
		prefName.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){

			@Override
			public boolean onPreferenceChange(Preference preference,
					Object newValue) {
				Log.i(tag,"New Value -" + newValue);
				prefName.setTitle("Name :"+ newValue);
				prefName.setText((String) newValue);
				return false;
			}});
		
		prefSex.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){

			@Override
			public boolean onPreferenceChange(Preference preference,
					Object newValue) {
				Log.i(tag,"sex value "+newValue);
				prefSex.setTitle("Sex ("+newValue+")");
				prefSex.setValue((String) newValue);
				return false;
			}});
		
		
		prefName.setTitle("Name : " +prefName.getText());
		prefSex.setTitle("Sex ("+prefSex.getValue()+")");
		
	}
	
	
	
	
	
	

}
