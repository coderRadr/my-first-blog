package net.codersadda.myblog.service;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.codersadda.myblog.dao.ContactsRepo;
import net.codersadda.myblog.entity.ContactDetails;

@Component
public class ContactService {
	
	public static Logger log = LoggerFactory.getLogger(ContactService.class);
	
	@Autowired
	private ContactsRepo repoService;

	public List<ContactDetails> getDeveloperDetails() {
		log.info("Entering contacts repo service:: "+ LocalDateTime.now());
		return (List<ContactDetails>) repoService.findAll();
	}

}
