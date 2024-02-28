package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp/v1")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository repo;
	
	
	
	
	//localhost:9091/emp/v1
	@GetMapping("/mk")
	public ResponseEntity<List<Employee>> getallItem() {

		List<Employee> list = repo.findAll();

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}
	
	
	//localhost:9091/emp/v1/1
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getitemById(@PathVariable("id") Integer id) {

		Optional<Employee> opt = repo.findById(id);

		return new ResponseEntity<Optional<Employee>>(opt, HttpStatus.OK);

	}

	
	//localhost:9091/emp/v1
		@PostMapping()
		public String addItem(@RequestBody Employee employee) {

			boolean flag = repo.existsById(employee.getId());

			if (flag == true) {

				return "Item already exists";

			} else {

				repo.save(employee);

				return "Item added to database";
			}

		}

		//localhost:9091/emp/v1
		@PutMapping("")

		public String updateItem(@RequestBody Employee employee) {

			boolean flag = repo.existsById(employee.getId());

			if (flag == true) {
				repo.saveAndFlush(employee);

				return "The Item is updated";
			}

			else {

				return "Item Id doent not exits";

			}

		}
	
		//localhost:9091/emp/v1/2
		@DeleteMapping("/{id}")
		
		public String deleteItem(@PathVariable ("id") Integer id) {
			
			boolean flag= repo.existsById(id);
			if(flag==true) {
				
				repo.deleteById(id);
				
				return "The Item is  deleted.";
			}
			
			else {
				
				return "Sorry, The item doesn't  exist";
			}
			
			
		}

}
