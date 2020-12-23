package com.bl.addrbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bl.addrbook.dto.ContactDTO;
import com.bl.addrbook.dto.ResponseDTO;
import com.bl.addrbook.service.IAddressBookService;

@RestController
@CrossOrigin(origins = "*")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	/**
	 * This API is used to add contacts
	 * @param contact
	 * @return ResponseEntity<ResponseDTO>
	 */
	@PostMapping(value = "/add")
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contact) {
		return new ResponseEntity<ResponseDTO>(addressBookService.addContact(contact), HttpStatus.OK);
	}

	/**
	 * This API is used to get a list of all contacts
	 * @return ResponseEntity<List<ContactDTO>>
	 */
	@GetMapping(value = "/list")
	public ResponseEntity<List<ContactDTO>> getContactList() {
		return new ResponseEntity(addressBookService.getContactList(), HttpStatus.OK);
	}

	/**
	 * This API is used to get a particular contact, given its contact ID
	 * @param contactId
	 * @return ResponseEntity<ContactDTO>
	 */
	@GetMapping(value = "/{contactid}")
	public ResponseEntity<ContactDTO> getContactById(@PathVariable("contactid") int contactId) {
		return new ResponseEntity(addressBookService.getContactById(contactId), HttpStatus.OK);
	}

	/**
	 * This API is used to delete a contact
	 * @param contactId
	 * @return ResponseEntity<ResponseDTO>
	 */
	@DeleteMapping(value = "/delete{contactid}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("contactid") int contactId) {
		return new ResponseEntity(addressBookService.deleteContact(contactId), HttpStatus.OK);
	}

	/**
	 * This API is used to update a contact, given its contact ID
	 * @param contactId
	 * @param contact
	 * @return ResponseEntity<ResponseDTO>
	 */
	@PutMapping(value = "/update{contactid}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable("contactid") int contactId,
			@RequestBody ContactDTO contact) {
		return new ResponseEntity(addressBookService.updateContact(contactId, contact), HttpStatus.OK);
	}

}
