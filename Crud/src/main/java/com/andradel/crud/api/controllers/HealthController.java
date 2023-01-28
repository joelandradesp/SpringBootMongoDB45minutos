package com.andradel.crud.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
@CrossOrigin
public class HealthController {
	
	@GetMapping("/ready")
	public ResponseEntity<String> getReady(){
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("/live")
	public ResponseEntity<String> getLive(){
		return ResponseEntity.ok("OK");
	}

}
