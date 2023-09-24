package com.jts.ehcach.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	private final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);

	@Cacheable(value = "areaOfSquareCache", condition = "#side > 5")
	public double areaOfSquare(int side) {
		LOG.info("Calculate the area of a SQUARE with a side of {}", side);
		return side * side;
	}

	@CacheEvict(cacheNames = { "areaOfSquareCache" }, allEntries = true)
	public void clearCache() {
		LOG.info("Clear Cache...");
	}
}
