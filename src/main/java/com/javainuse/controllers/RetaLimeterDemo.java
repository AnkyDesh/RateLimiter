package com.javainuse.controllers;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;

@RestController
@RequestMapping()
public class RetaLimeterDemo {
	private 	Bucket bucket;
	
	@GetMapping("/token_genrete")
	public ResponseEntity<String> genreteToken(){
		Refill refill=Refill.of(5, Duration.ofMinutes(1));
		 bucket=Bucket4j.builder()
				.addLimit(Bandwidth.classic(5, refill))
				.build();
		    return new ResponseEntity<String>("genrete successfull|||",HttpStatus.OK);
	}
	
	
	@GetMapping("/demo")
	public ResponseEntity<String> demo(){
		if(bucket.tryConsume(1)) {
			System.out.println("====API successfully working========");
			return new ResponseEntity<String>("Suceess",HttpStatus.OK);		
		}
		System.out.println("==== number of hits exceeded=============");
		return new ResponseEntity<String>("Too many Hits || please try later",HttpStatus.TOO_MANY_REQUESTS);
	}

}
