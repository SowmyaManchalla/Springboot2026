package com.May2026.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*@RestController
class hellocontroller
{
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello Springboot";
	}
	
	@PostMapping("/create")
	public String createapp()
	{
		return "Data created successfully";
	}
	
	@PutMapping("/update")
	public String updateapp()
	{
		return "Data update successfully";
	}
	
	@DeleteMapping("/delete")
	public String deleteapp()
	{
		return "Data deleted successfully";
	}
}*/