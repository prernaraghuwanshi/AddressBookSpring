package com.bl.addrbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.addrbook.model.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer>{
	
}
