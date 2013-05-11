package com.AnonymousApps.todo;
	 
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
	 
public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {
	  
	EditText txtItem;
	Button btnAdd; 
	ListView taskItems;
	PopupWindow popUp;
	 
	ArrayList<String> toDoItems;
	ArrayAdapter<String> tasks;
	  
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
	   
	   
	   
		 txtItem = (EditText)findViewById(R.id.txtItem);
		 btnAdd = (Button)findViewById(R.id.btnAdd);
		 taskItems = (ListView)findViewById(R.id.taskItems);
		 popUp = new PopupWindow(this);
		   
		 btnAdd.setOnClickListener((android.view.View.OnClickListener) this);
		   
		 toDoItems = new ArrayList<String>();
		 tasks = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);
		 taskItems.setAdapter(tasks);
		 
		 ((OnLongClickListener) taskItems).onLongClick(taskItems);
	  }
	 
	  public void addItem(String item) {
	   if(item.length() > 0) {
	    this.toDoItems.add(item);
	    this.tasks.notifyDataSetChanged();
	    this.txtItem.setText("");
	    } 
	   }
	 
	  public void onClick(View v) {
	   if(v == this.btnAdd) {
	    this.addItem(this.txtItem.getText().toString());
	   }
	  }

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if(v == this.taskItems)
			return true;
		return false;
	}
}