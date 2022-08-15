package com.bootcamp.java.spp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.java.spp.exception.ResourceNotFoundException;
import com.bootcamp.java.spp.model.Person;
import com.bootcamp.java.spp.repository.PersonRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	// get all person
	@GetMapping("/person")
	public List<Person> getAllperson(){
		return personRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/person")
	public Person createEmployee(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	// get employee by id rest api
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getEmployeeById(@PathVariable Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not exist with id :" + id));
		return ResponseEntity.ok(person);
	}
	
	// update employee rest api
	
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updateEmployee(@PathVariable Long id, @RequestBody Person personDetails){
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not exist with id :" + id));
		
		person.setFirstName(personDetails.getFirstName());
		person.setLastName(personDetails.getLastName());
		person.setEmail(personDetails.getEmail());
		
		Person updatedEmployee = personRepository.save(person);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not exist with id :" + id));
		
		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}