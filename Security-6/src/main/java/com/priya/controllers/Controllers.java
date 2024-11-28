package com.priya.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	@GetMapping("/")
	public String home()
	{
		return "Welcome";
	}

}
