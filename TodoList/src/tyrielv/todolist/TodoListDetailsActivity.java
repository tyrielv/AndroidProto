package tyrielv.todolist;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TodoListDetailsActivity extends ListActivity {
	public final static String LISTNAME_MESSAGE = "tyrielv.todolist.Listname";
	
	private ArrayList<String> itemNames = new ArrayList<String>();
	private ArrayAdapter<String> adapter;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String listName = intent.getStringExtra(LISTNAME_MESSAGE);
		setTitle("Testing");
		setContentView(R.layout.activity_todo_list_details);		
		TextView listNameView = (TextView)findViewById(R.id.listNameTextView);
		listNameView.setText(listName);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNames); 
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onCreateNewItemButtonClick(View v) {
		EditText newItemTextBox = (EditText)findViewById(R.id.newTodoListItemTextBox);
		String newItem = newItemTextBox.getText().toString();
		if (newItem.length() > 0) {
			itemNames.add(newItem);
			adapter.notifyDataSetChanged();
		}
		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		//Intent intent = new Intent(this);
		
	}
}
