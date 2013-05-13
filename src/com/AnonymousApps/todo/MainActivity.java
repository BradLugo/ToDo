package com.AnonymousApps.todo;
 
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
 
public class MainActivity extends Activity implements OnClickListener {
    EditText field;
    Button btnAdd; 
    ListView taskItems;
    Object position;

    ArrayList<String> toDoItems;
    ArrayAdapter<String> adapter;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	
    	field = (EditText)findViewById(R.id.txtItem);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        taskItems = (ListView)findViewById(R.id.taskItems);
   
        btnAdd.setOnClickListener((android.view.View.OnClickListener) this);
        registerForContextMenu(taskItems);
   
        toDoItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, toDoItems);
        taskItems.setAdapter(adapter);
        taskItems.setItemsCanFocus(false);
        taskItems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
 
    public void addItem(String item) {
        if(item.length() > 0) {
            this.toDoItems.add(item);
            this.adapter.notifyDataSetChanged();
            this.field.setText("");
        } 
    }
 
    public void onClick(View v) {
        if(v == this.btnAdd) {
            this.addItem(this.field.getText().toString());
        }
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
     // TODO Auto-generated method stub
     super.onCreateContextMenu(menu, v, menuInfo);
     
     AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
     position = adapter.getItem(info.position);
     menu.add("Edit");
     menu.add("Remove");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
     // TODO Auto-generated method stub
     super.onContextItemSelected(item);
     
     if(item.getTitle() == "Edit") {
    	 
    	 toDoItems.set(position);
    	 adapter.notifyDataSetChanged();
     }
     
     if(item.getTitle() == "Remove") {
    	 toDoItems.remove(position);
    	 adapter.notifyDataSetChanged();
     }
     
     return true;
    }
}
