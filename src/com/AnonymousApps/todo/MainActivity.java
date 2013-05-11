 package com.AnonymousApps.todo;
 
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
 
public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {
  
	EditText txtItem;
    Button btnAdd; 
    ListView taskItems;
    View view;
    LayoutInflater inflater;
 
    ArrayList<String> toDoItems;
    ArrayAdapter<String> tasks;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
    	view = new View(this);
        txtItem = (EditText)findViewById(R.id.txtItem);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        taskItems = (ListView)findViewById(R.id.taskItems);
        inflater = new LayoutInflater((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
   
        btnAdd.setOnClickListener((android.view.View.OnClickListener) view);
   
        toDoItems = new ArrayList<String>();
        tasks = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, toDoItems);
        taskItems.setAdapter(tasks);
        taskItems.setItemsCanFocus(false);
        taskItems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        
        ((OnLongClickListener) taskItems).onLongClick(view);
   
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
    
    public boolean onLongClick(View v) {
		return false;
    }
}
