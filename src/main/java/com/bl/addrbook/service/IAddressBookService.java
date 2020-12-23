package com.bl.addrbook.service;

import java.util.List;

import com.bl.addrbook.dto.ContactDTO;
import com.bl.addrbook.dto.ResponseDTO;
import com.bl.addrbook.model.Contact;


public interface IAddressBookService {
	
	public ResponseDTO addContact(ContactDTO contact);

	public List<Contact> getContactList();
	
	public Contact getContactById(int contactId);
	
	public ResponseDTO deleteContact(int contactId);

	public ResponseDTO updateContact(int contactId, ContactDTO contact);

}
