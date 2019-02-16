package com.springtutorial.aspect.oriented.programming.siddartha;

import org.springframework.stereotype.Component;

@Component
public class Blender implements IBlender {
	public void startBlender() {
		System.out.println("   ***** Blender started *****");
	}
}
