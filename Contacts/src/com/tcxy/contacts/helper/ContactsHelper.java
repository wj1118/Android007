package com.tcxy.contacts.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.tcxy.contacts.domain.Contact;

public class ContactsHelper {

	public static final String AUTHORITY = "com.android.contacts";
	
	private Context context;

	public ContactsHelper(Context context){
		this.context = context;
	}

	public List<Contact> getContacts(){

		//1、获得ContentResolver
		ContentResolver resolver = context.getContentResolver();

		//2、Uri 这个时候，我们要去看一下数据库的结构。
		
		Cursor cursor = resolver.query(Uri.parse("content://"+AUTHORITY+"/raw_contacts"),new String[]{"_id"}, null, null, null);
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		while(cursor.moveToNext()){
			
			long contact_id = cursor.getLong(0);
			Cursor c = resolver.query(Uri.parse("content://"+AUTHORITY+"/data"),new String[]{"data1","mimetype","raw_contact_id"}, "raw_contact_id=?", new String[]{Long.toString(contact_id)}, null);
			Contact contact = new Contact();
			while(c.moveToNext()){
				if(c.getString(1).equals("vnd.android.cursor.item/phone_v2")){
					//电话号码
					contact.setNumber(c.getString(0));
				}
				if(c.getString(1).equals("vnd.android.cursor.item/name")){
					//姓名
					contact.setName(c.getString(0));
				}
			}
			contacts.add(contact);
			c.close();
		}
		cursor.close();
		return contacts;
	}
}
