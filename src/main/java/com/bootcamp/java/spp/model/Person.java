package com.bootcamp.java.spp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(name = "document")
	private String document;	

	@Column(name = "typeafp")
	private String typeafp;	
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "last_name")
	private String lastName;	
	
	@Column(name = "email")
	private String email;
	
	
}