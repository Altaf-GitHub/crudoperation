package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "employee")
@Data
public class Employee {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String eName;
	private String department;
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
