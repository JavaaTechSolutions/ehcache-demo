package com.jts.ehcach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

	private CalculatorService calculatorService;
	
	@Autowired
	private CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	@GetMapping("/areaOfSquare")
	public ResponseEntity<Double> areaofSquare(@RequestParam int side) {
		return ResponseEntity.ok(calculatorService.areaOfSquare(side));
	}
	
	@GetMapping(path = "/evict")
	public ResponseEntity<String> evictCache() {
		calculatorService.clearCache();
		return ResponseEntity.ok("Cache successfully clean");
	}
}
