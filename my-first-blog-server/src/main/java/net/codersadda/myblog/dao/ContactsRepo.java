package net.codersadda.myblog.dao;

import org.springframework.data.repository.CrudRepository;

import net.codersadda.myblog.entity.ContactDetails;

public interface ContactsRepo extends CrudRepository<ContactDetails, Integer>{

}
