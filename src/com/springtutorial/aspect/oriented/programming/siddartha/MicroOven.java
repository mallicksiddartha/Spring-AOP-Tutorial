package com.springtutorial.aspect.oriented.programming.siddartha;

import org.springframework.stereotype.Component;

@Component
public class MicroOven implements IMicroOven {
	
	public void startOven() {
		System.out.println("   ***** Oven started *****");
	}
}
