package com.barclays.student.adharapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.student.adharapp.dto.Person;
import com.barclays.student.adharapp.repository.PersonRepository;

@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
		public Person getProductById(int id) {
			Optional<Person> persons=personRepository.findById(id);
			if(persons.isPresent()) {
			return persons.get();
			
		}
			else
				return null;
		}
		public boolean deletePerson(int id) {
			
			Person person=getProductById(id);
			if(person != null)
			{
				personRepository.delete(person);
				return true;
			}
			else
		    return false;
		}
		public Person updatePerson(int id, Person person) {
			Person existingPerson=getProductById(id);
			if(existingPerson !=null)
			{
			existingPerson.setName(person.getName());
			existingPerson.setEmail(person.getEmail());
			existingPerson.setPhone(person.getPhone());
			existingPerson.setAdharNumber(person.getAdharNumber());
			
			return personRepository.save(existingPerson);
		}
			return null;
		}
		public List<Person> getAllPersons() {
			return personRepository.findAll();
		}
				
}

