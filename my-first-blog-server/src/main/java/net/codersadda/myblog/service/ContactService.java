package net.codersadda.myblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.codersadda.myblog.entity.ContactDetails;

@Component
public class ContactService {

	public List<ContactDetails> getDeveloperDetails() {
		List<ContactDetails> details = new ArrayList<>();
		details.add(new ContactDetails("Mohan", "mohankanuri@outlook.com", "111-222-3333", "Java 8, Spring, Spring boot, Angular, DRools"));
		details.add(new ContactDetails("Ishtiaq", "ishtiaq@gmail.com", "111-222-3333", "Java 8, Spring, Spring boot, Angular, DRools"));
		return details;
	}

}
