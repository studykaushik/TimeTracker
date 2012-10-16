package ray.kaushik.timetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class TimeTrackerDBHelper {
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "timeTrackerDB.db";
	private static final String TABLE_NAME = "timerecords";
	
	public static final String TIMETRACKER_COLUMN_ID = "id";
	public static final String TIMETRACKER_COLUMN_TIME = "time";
	public static final String TIMETRACKER_COLUMN_NOTES = "notes";
	
	private TimeTrackerOpenHelper openHelper;
	private SQLiteDatabase database;
	
	public TimeTrackerDBHelper(Context context) {
		openHelper = new TimeTrackerOpenHelper(context);
		database = openHelper.getWritableDatabase();
	}
	
	public void saveTimeRecord(String time, String notes){
		ContentValues contentValues = new ContentValues();
		contentValues.put(TIMETRACKER_COLUMN_TIME,time );
		contentValues.put(TIMETRACKER_COLUMN_NOTES,notes );
		
		database.insert(TABLE_NAME, null, contentValues);
	}
	public class TimeTrackerOpenHelper extends SQLiteOpenHelper{

		public TimeTrackerOpenHelper(Context context) {
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE_NAME + 
					" ( " + TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, " + TIMETRACKER_COLUMN_TIME +  " TEXT, " + TIMETRACKER_COLUMN_NOTES  +  " TEXT)"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(
					"DROP TABLE IF EXISTS " + TABLE_NAME
					);
			onCreate(db);
		}
		
	}

}
