package com.barclays.student.adharapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.student.adharapp.dto.Person;
import com.barclays.student.adharapp.dto.ResponseStructure;
import com.barclays.student.adharapp.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@PostMapping("/person")
	public ResponseStructure<Person> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	@GetMapping("person/{id}")
	public ResponseStructure<Person> getProductById(@RequestParam int id) {
		return personService.getProductById(id);
}
	@PatchMapping("person/{id}")
	public ResponseStructure<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
		return personService.updatePerson(id,person);
	}
	@GetMapping("person")
	public ResponseStructure<List<Person>> getAllProducts() {
		return personService.getAllPersons();
	}
	@DeleteMapping("person/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
}
