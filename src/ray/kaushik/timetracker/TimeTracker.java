package ray.kaushik.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class TimeTracker extends Activity{
	private Time_Tracker_Adapter timeTrackerAdapter;
	public static final int TIME_ENTRY_REQUEST_CODE = 1;
	public static final int TIME_ENTRY_REQUEST_CODE_ABOUT = 2;
	public TimeTrackerDBHelper timeTrackerDBHelper;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time__tracker_layout);
		
		ListView timeTrackerListView = (ListView) findViewById(R.id.time_tracker_layout_id);
		timeTrackerAdapter = new Time_Tracker_Adapter();
		timeTrackerListView.setAdapter(timeTrackerAdapter);
		
		timeTrackerDBHelper = new TimeTrackerDBHelper(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu m) { 
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.time_list_menu, m );
		return super.onCreateOptionsMenu(m);
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item){
		if(item.getItemId() == R.id.add_record){
			Intent intent = new Intent(this,AddTimeActivity.class);
			startActivityForResult(intent, TIME_ENTRY_REQUEST_CODE);
			return true;
		}else if(item.getItemId() == R.id.aboutId){
			Intent intent = new Intent(this,AboutActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == TIME_ENTRY_REQUEST_CODE){
			if(resultCode == RESULT_OK){
				String time = data.getStringExtra("time");
				String notes = data.getStringExtra("notes");
				
				timeTrackerDBHelper.saveTimeRecord(time,notes);
				timeTrackerAdapter.addTimeRecord(new TimeTrackerRecord(time, notes));
				timeTrackerAdapter.notifyDataSetChanged();
			}
		}
		
	}
}
