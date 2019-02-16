package com.springtutorial.aspect.oriented.programming.siddartha;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public void start() {
		System.out.println("Starting car, volkswagen. Polluted smoke everywhere!!");
	}
}
