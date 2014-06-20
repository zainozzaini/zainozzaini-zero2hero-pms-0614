package edu.pms.z2h_old.myclimbers.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "myclimbers.db";
	private static final int DATABASE_VERSION = 1;


	//Design our table
	public static final String TABLE_CHECKIN = "checkin";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_CHECKPOINT = "checkpoint";
	public static final String COLUMN_DATETIME = "datetime";

	// Create our table
	private static final String DATABASE_CREATE = "create table "
				+ TABLE_CHECKIN + "(" + 
				COLUMN_ID + " integer primary key autoincrement, " 
				+ COLUMN_CHECKPOINT + " text not null," 
				+ COLUMN_DATETIME + " text" +
			 ");";



	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKIN);
		onCreate(db);

	}



}
