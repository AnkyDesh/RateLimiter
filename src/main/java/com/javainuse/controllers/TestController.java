package com.javainuse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;

@RestController
@CrossOrigin()
public class TestController {
	
	 @RequestMapping({"/testuri"})
	    public String hello() {
	        return "Hello World !! Rest Controller is working ...";
	    }
	
	

}
