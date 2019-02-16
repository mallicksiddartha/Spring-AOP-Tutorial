package com.springtutorial.aspect.oriented.programming.siddartha;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtutorial.aspect.oriented.programming.camera.product.Cover;
import com.springtutorial.aspect.oriented.programming.siddartha.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springtutorial/aspect/oriented/programming/siddartha/camera_beans.xml");
		// Camera camera = (Camera) context.getBean("camera");
		// Lens lens = (Lens) context.getBean("lens");
		// Cover cover = (Cover) context.getBean("cover");
		IMicroOven microOven = (IMicroOven) context.getBean("microOven");
		IBlender blender = (IBlender) context.getBean("blender");
		// System.out.println("Getting camera class : " + camera.getClass());
		// System.out.println("camera is instanceof Camera class: " + (camera instanceof
		// Camera));
		// System.out.println("camera is instanceof PhotoSnapper interface: " + (camera
		// instanceof PhotoSnapper));
		// System.out.println("camera is instanceof ICamera interface: " + (camera
		// instanceof ICamera));
		/*
		 * commented for using "Introduction" Car car = (Car) context.getBean("car");
		 * 
		 * try { camera.snap(); System.out.println(); } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * camera.snap(1230); camera.snap(1230, 2.8); System.out.println();
		 * camera.snap("Basecamp"); System.out.println(); camera.snapNightMode();
		 * System.out.println(); camera.snap("Basecamp"); camera.snapCar(car);
		 * 
		 * car.start();
		 * 
		 * lens.zoom(5); System.out.println();cover.rainProof(true);
		 */
		microOven.startOven();
		((IMachine) microOven).start();
		
		blender.startBlender();
		((IMachine) blender).start();
		

		context.close();

	}

}
