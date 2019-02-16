package com.springtutorial.aspect.oriented.programming.siddartha;

import org.springframework.stereotype.Component;

@Component
public class Camera implements PhotoSnapper, ICamera{

	public Camera() {
	}

	public void snap() throws Exception {
		System.out.println("SNAP SNAP");

		throw new Exception("Hoichi san sugoi desu ne!!!");
	}

	@Deprecated
	public void snap(int exposure) {
		System.out.println("SNAP SNAP!! with exposure: " + exposure);
	}
	
	public void snap(int exposure, double zoom) {
		System.out.println("SNAP SNAP!! with exposure: " + exposure + " and zoom: " + zoom);
	}

	public void snap(String location) {
		System.out.println("SNAP SNAP!! with location: " + location);
		
	}
	
	public void snap(String location, String person) {
		System.out.println("SNAP SNAP!! with location: " + location + " and with person: " + person);
		
	}

	public void snapNightMode() {
		System.out.println("SNAP SNAP!! with night mode...");
	}
	
	public void snapCar(Car car) {
		System.out.println("SNAPPING buggati...");
	}

}
