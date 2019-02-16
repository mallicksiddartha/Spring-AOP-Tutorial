package com.springtutorial.aspect.oriented.programming.camera.product;

import org.springframework.stereotype.Component;

@Component
public class Cover {
	
	public void rainProof(boolean rainProof) {
		System.out.println("The cover is rain proof? " + rainProof);
	}

}
