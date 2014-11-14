package com.tcxy.contacts.service;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.tcxy.contacts.domain.Contact;
import com.tcxy.contacts.helper.ContactsHelper;

public class ContactService extends Service
{
	
	public class ContactBinder extends Binder{
		public List<Contact> getAllContacts(){
			return ContactService.this.getAllContacts();
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new ContactBinder();
	}
	
	public List<Contact> getAllContacts(){
		
		return new ContactsHelper(this).getContacts();
	}

}
