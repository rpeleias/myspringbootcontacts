package com.rodrigopeleias.myspringcontacts.repository;

import com.rodrigopeleias.myspringcontacts.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

    List<Contact> findAllByOrderByNameDesc();
}
