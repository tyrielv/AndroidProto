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

public class TodoListActivity extends ListActivity {
	public final static String USERNAME_MESSAGE = "tyrielv.todolist.Username";
	
	private ArrayList<String> listNames = new ArrayList<String>();
	private ArrayAdapter<String> adapter;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String userName = intent.getStringExtra(USERNAME_MESSAGE);
		setContentView(R.layout.activity_todo_lists);		
		TextView userNameView = (TextView)findViewById(R.id.userNameTextView);
		userNameView.setText(userName + "'s\nTo Do Lists");
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames); 
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onCreateNewListButtonClick(View v) {
		EditText newListTextBox = (EditText)findViewById(R.id.newTodoListTextBox);
		String newTodoList = newListTextBox.getText().toString();
		if (newTodoList.length() > 0) {
			listNames.add(newTodoList);
			adapter.notifyDataSetChanged();
		}
		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		//Intent intent = new Intent(this);
		
	}
}
