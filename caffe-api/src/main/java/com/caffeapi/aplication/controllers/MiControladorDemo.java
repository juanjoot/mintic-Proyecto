package com.caffeapi.aplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiControladorDemo {

	@GetMapping(value = "Demo")
	public String saludar () {
		return "hola como estas";
	}
}