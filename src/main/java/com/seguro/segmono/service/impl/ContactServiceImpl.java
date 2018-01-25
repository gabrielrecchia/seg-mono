package com.seguro.segmono.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seguro.segmono.component.ContactConverter;
import com.seguro.segmono.entity.Contact;
import com.seguro.segmono.model.ContactModel;
import com.seguro.segmono.repository.ContactJpaRepository;
import com.seguro.segmono.service.ContactService;



@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	@Qualifier("contactJpaRepository")
	private ContactJpaRepository contactJpaRepository;
	
	@Autowired
	@Qualifier("contactConverter")	
	private ContactConverter contactConverter ;
	
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {	
		Contact contact = contactJpaRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactJpaRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));
		}
		return contactsModel;
	}


	
	
	//@Override
	//public int removeContact(int id) {
	//	contactJpaRepository.delete(id);
	//	return 0;
	//}

	//@Override
	//public Contact updateContact(Contact Contact) {
	//	contactJpaRepository.save(Contact);
	//	return null;
	//}

}
