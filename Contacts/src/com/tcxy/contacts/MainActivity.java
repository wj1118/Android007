package com.tcxy.contacts;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tcxy.contacts.domain.Contact;
import com.tcxy.contacts.service.ContactService;

public class MainActivity extends Activity {

	private ListView lv_contacts;
	
	private List<Contact> contacts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv_contacts = (ListView)findViewById(R.id.lv_contacts);
		
		lv_contacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		
		lv_contacts.setMultiChoiceModeListener(new MultiChoiceModeListener() {
			
			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onDestroyActionMode(ActionMode mode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				getMenuInflater().inflate(R.menu.main, menu);
				return true;
				
			}
			
			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onItemCheckedStateChanged(ActionMode mode, int position,
					long id, boolean checked) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Intent intent = new Intent(this,ContactService.class);
		bindService(intent,new MyServiceConn(),Context.BIND_AUTO_CREATE);
	}
	
	class MyServiceConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			contacts = ((ContactService.ContactBinder)service).getAllContacts();
			
			lv_contacts.setAdapter(new ContactAdapter());
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
			
		}
	};
	
	class ContactAdapter extends BaseAdapter{
		@Override
		public int getCount() {
		
			return contacts.size();
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(MainActivity.this,R.layout.contact_item, null);
			TextView name = (TextView)view.findViewById(R.id.tv_name);
			TextView number = (TextView)view.findViewById(R.id.tv_number);
			name.setText(contacts.get(position).getName());
			number.setText(contacts.get(position).getNumber());
			return view;
		}
	}
	
}
