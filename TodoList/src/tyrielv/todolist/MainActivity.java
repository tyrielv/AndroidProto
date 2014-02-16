package tyrielv.todolist;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MainActivity extends ListActivity {	
	
	private ArrayList<String> users = new ArrayList<String>();
	private ArrayAdapter<String> adapter;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, users); 
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onCreateNewUserButtonClick(View v) {
		EditText newUserTextBox = (EditText)findViewById(R.id.newUserTextBox);
		String newUserName = newUserTextBox.getText().toString();
		if (newUserName.length() > 0) {
			users.add(newUserName);
			adapter.notifyDataSetChanged();
		}
	}

}
