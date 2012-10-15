package ray.kaushik.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AddTimeActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_time);
		
	}
	
	public void onCancel(View view){
		finish();
	}
	
	public void onSave(View view){
		Intent intent = getIntent();
		EditText timeTextValue = (EditText) findViewById(R.id.time_view);
		intent.putExtra("time", timeTextValue.getText().toString());
		
		EditText notesTextValue = (EditText) findViewById(R.id.notes_view);
		intent.putExtra("notes", notesTextValue.getText().toString());
		
		this.setResult(RESULT_OK, intent);
		finish();
	}
	
}
