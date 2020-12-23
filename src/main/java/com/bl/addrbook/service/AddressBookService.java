package com.bl.addrbook.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.addrbook.dto.ContactDTO;
import com.bl.addrbook.dto.ResponseDTO;
import com.bl.addrbook.exception.BadRequestException;
import com.bl.addrbook.exception.ContactException;
import com.bl.addrbook.exception.NotFoundException;
import com.bl.addrbook.model.Contact;
import com.bl.addrbook.repository.IContactRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IContactRepository contactRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Function to add a contact
	 */
	@Override
	public ResponseDTO addContact(ContactDTO contact) {
		if (contact == null) {
			throw new BadRequestException("Incorrect Contact details");
		}
		Contact contactEntity = modelMapper.map(contact, Contact.class);
		contactEntity = contactRepository.save(contactEntity);
		if (contactEntity != null) {
			return new ResponseDTO("Contact added successfully");
		} else {
			return new ResponseDTO("Failed to insert Data");
		}
	}

	/**
	 * Function to get list of all contacts
	 */
	@Override
	public List<Contact> getContactList() {
		List<Contact> contactList = contactRepository.findAll();
		if (contactList == null || contactList.isEmpty()) {
			throw new NotFoundException("No Data Found of any Contact");
		}
		return contactList;
	}

	/**
	 * Function to get contact, given contact ID
	 */
	@Override
	public Contact getContactById(int contactId) {
		Contact contactEntity = new Contact();
		contactEntity = contactRepository.findById(contactId).orElseThrow(() -> new NotFoundException("Contact does not exist"));
		return contactEntity;		
	}

	/**
	 * Function to delete contact
	 */
	@Override
	public ResponseDTO deleteContact(int contactId) {
		try {
			contactRepository.deleteById(contactId);
			return new ResponseDTO("Contact deleted successfully");
		} catch (ContactException e) {
			return new ResponseDTO("Error while deleting");
		}
	}

	/**
	 * Function to update contact, given contact ID
	 */
	@Override
	public ResponseDTO updateContact(int contactId, ContactDTO contact) {
		Contact contactEntity = contactRepository.findById(contactId).get();
		modelMapper.map(contact, contactEntity);
		contactEntity = contactRepository.save(contactEntity);
		if (contactEntity != null) {
			return new ResponseDTO("Contact updated successfully");
		} else {
			return new ResponseDTO("Failed to update Data");
		}
	}
}
