package com.seguro.segmono.service;

import java.util.List;

import com.seguro.segmono.model.ContactModel;


public interface ContactService {
	

	
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	//public abstract int removeContact(int id);
	
	//public abstract Contact updateContact(ContactModel contactModel);

}
