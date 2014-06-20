package edu.pms.z2h_old.myclimbers.db;

import java.util.ArrayList;
import java.util.List;

import edu.pms.z2h_old.myclimbers.obj.Checkin;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CheckinDB {

	// Database fields
	private SQLiteDatabase database;
	private DbHelper dbHelper;

	private String[] allColumns = { DbHelper.COLUMN_ID,DbHelper.COLUMN_CHECKPOINT,DbHelper.COLUMN_DATETIME };


	public CheckinDB(Context context) {
		dbHelper = new DbHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}




	public Checkin createCheckin(Checkin checkin) {
		ContentValues values = new ContentValues();
		values.put(DbHelper.COLUMN_CHECKPOINT, checkin.getCheckPoint());
		values.put(DbHelper.COLUMN_DATETIME, checkin.getTime());

		long insertId = database.insert(DbHelper.TABLE_CHECKIN, null,
				values);

		Cursor cursor = database.query(DbHelper.TABLE_CHECKIN,
				allColumns, DbHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);

		cursor.moveToFirst();

		Checkin newCheckin = cursorToCheckin(cursor);
		cursor.close();
		return newCheckin;
	}
	
	
	
	

	public void deleteCheckin(Checkin checkin) {
		long id = checkin.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(DbHelper.TABLE_CHECKIN, DbHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Checkin> getAllCheckins() {
		List<Checkin> checkins = new ArrayList<Checkin>();

		Cursor cursor = database.query(DbHelper.TABLE_CHECKIN,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Checkin chkin = cursorToCheckin(cursor);
			checkins.add(chkin);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return checkins;
	}
	
	

	private Checkin cursorToCheckin(Cursor cursor) {
		Checkin checkin = new Checkin();
		checkin.setId(cursor.getLong(0));
		checkin.setCheckPoint(cursor.getString(1));
		checkin.setTime(cursor.getString(2));
		return checkin;
	}

}
