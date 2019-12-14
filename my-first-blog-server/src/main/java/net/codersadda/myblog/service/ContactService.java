package net.codersadda.myblog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.codersadda.myblog.dao.ContactsRepo;
import net.codersadda.myblog.entity.ContactDetails;

@Component
public class ContactService {
	
	public static Logger log = LogManager.getLogger(ContactService.class);
	
	@Autowired
	private ContactsRepo repoService;

	public List<ContactDetails> getDeveloperDetails() {
		log.info("Entering contacts repo service:: "+ LocalDateTime.now());
		return (List<ContactDetails>) repoService.findAll();
	}

}
