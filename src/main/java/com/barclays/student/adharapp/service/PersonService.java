package com.barclays.student.adharapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barclays.student.adharapp.dao.PersonDao;
import com.barclays.student.adharapp.dto.Person;
import com.barclays.student.adharapp.dto.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	public ResponseStructure<Person> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Person saved");
		responseStructure.setData(personDao.savePerson(person));
		return responseStructure;
	}
	
	public ResponseStructure<Person> getProductById(int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Person saved");
		responseStructure.setData(personDao.getProductById(id));
		return responseStructure;
	}
	public ResponseStructure<Person> updatePerson(int id,Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Person Updated");
		responseStructure.setData(personDao.updatePerson(id, person));
		return responseStructure;
	}
	public ResponseStructure<List<Person>> getAllPersons() {
		ResponseStructure<List<Person>> responseStructure = new ResponseStructure<List<Person>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Person Updated");
		responseStructure.setData(personDao.getAllPersons());
		return responseStructure;
	}
	public boolean deletePerson(int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if(personDao.deletePerson(id)) {
		return true;
		}
		else
			return false;
	}
}
