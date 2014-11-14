package com.tcxy.popupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_helloworld;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_helloworld = (TextView)findViewById(R.id.tv_helloworld);
	}
	
	public void showPopupMenu(View view){
		
		
		Log.i("MYLOG","===============================");
		
		//1¡¢Instantate a PopupMenu with its constructor, which takes the current application Context and the View to which the menu should be anchored.
		PopupMenu popupMenu = new PopupMenu(this, tv_helloworld);
		
		//2¡¢Use MenuInflater to inflate your menu resource into the Menu object returned by PopupMenu.getMenuInflater(). On API level 14 and above, you can use PopupMenu.inflate() instead.
		
		popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
		
		// api level >=14 popupMenu.inflate(R.menu.main);
		
		//3¡¢Call PopupMenu.show().
		
		popupMenu.show();
	}

}
