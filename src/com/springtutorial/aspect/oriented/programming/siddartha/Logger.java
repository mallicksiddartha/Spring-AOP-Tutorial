package com.springtutorial.aspect.oriented.programming.siddartha;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@DeclareParents(value="com.springtutorial.aspect.oriented.programming.siddartha.*", defaultImpl=com.springtutorial.aspect.oriented.programming.siddartha.Machine.class)
	private IMachine machine;
	
	/**
	 * All methods called for any bean created from the package/child package of
	 * com.springtutorial.aspect.oriented.programming that have "Component" anotation
	 */
	//@Pointcut("within(@org.springframework.stereotype.Component com.springtutorial.aspect.oriented.programming..*)")
	
	/**
	 * All methods called for any bean created from the package/child package of
	 * com.springtutorial.aspect.oriented.programming package
	 */
	@Pointcut("within(com.springtutorial.aspect.oriented.programming..*)")
	
	/*
	 * All methods called for any bean created from the package/child package of
	 * com.springtutorial.aspect.oriented.programming that have "Deprecated" anotation
	 * here "bean" is important, "Deprecated" annotation on class is evaluated, not on methods
	 */
	//@Pointcut("within(@Deprecated com.springtutorial.aspect.oriented.programming..*)")
	public void withinDemo() {
		
	}
	
	/*
	 * All methods called for any beans created of type ICamera
	 * As far as I have studied, java library "Objenisis" is used for creating proxy for CGLIB
	 * This class creates proxy of a class, and all the interface it implements
	 * that's why all the methods that is not in the ICamera class is also considered by target 
	 * pointcut desingnator
	 */
	//@Pointcut("target(com.springtutorial.aspect.oriented.programming.siddartha.ICamera)")
	/*
	 * All the "Component" annotation is targeted
	 */
	//@Pointcut("@target(org.springframework.stereotype.Component)")
	
	/*
	 * targets the bean created for the class given inside the parentheses
	 */
	@Pointcut("target(com.springtutorial.aspect.oriented.programming.siddartha.Camera)")
	public void targetDemo() {
		
	}
	
	@Pointcut("this(com.springtutorial.aspect.oriented.programming.siddartha.ICamera)")
	public void thisDemo() {
		
	}
	
	/*
	 * Works for all methods that have annotation deprecated
	 */
	@Pointcut("@annotation(java.lang.Deprecated)")
	public void annotationDemo() {
		
	}
	
	/*
	 * Works for all methods that has a parameter argument which is created by
	 * @Component annotation. See the '@' in front of 'args', it means the argument type defined is
	 * created via an annotation
	 */
	//@Pointcut("@args(org.springframework.stereotype.Component)")
	
	/*
	 * methods that has one parameter, the type is int
	 */
	//@Pointcut("args(int)")
	
	/*
	 * methods that has one parameter, the type is int, any other number and type of parameter
	 */
	@Pointcut("args(int, *)")
	public void argsDemo() {
		
	}
	
	@Pointcut("args(exposure, zoom)")
	public void argsDemo2(int exposure, double zoom) {
		
	}
	
	/*
	 * bean pointcut, can put the name of the bean created
	 */
	//@Pointcut("bean(camera)")
	/*
	 * bean pointcut, beans that starts with 'c'
	 */
	@Pointcut("bean(c*)")
	public void beanDemo() {
		
	}
	
	/*@Pointcut("execution(* com.springtutorial.aspect.oriented.programming.siddartha.Camera.*(..))")
	public void cameraShopping() {
		
	}*/
	
	/*@Before("withinDemo() && !@annotation(Deprecated)")
	public void withinBeforeDemo() {
		System.out.println("****** WITHIN BEFORE DEMO ********");
	}*/
	
/*	@Before("cameraShopping()")
	public void shoppingKori() {
		System.out.println("before advice: Shopping for camera accessories...");
	}*/
	
	/*@After("withinDemo()")
	public void withinAfterDemo() {
		System.out.println("****** WITHIN AFTER DEMO ********");
	}*/
	
	/*@AfterReturning("withinDemo()")
	public void afterReturning() {
		System.out.println("After returning advice: This is after no error returning...");
	}
	
	
	@AfterThrowing("withinDemo()")
	public void afterThrowing() {
		System.out.println("This is after error returning...");
	}*/
	
	@Around("withinDemo()")
	public void withinAroundDemo(ProceedingJoinPoint p) {
		//System.out.println("****** WITHIN AROUND DEMO START ********");
		System.out.println("****** RUNNING ********");
		try {
			p.proceed();
		} catch (Throwable e) {
			System.out.println("****** WITHIN AROUND DEMO ******** EXCEPTION: " +e.getMessage().toUpperCase());
		}
		
		System.out.println("****** COMPLETED********");
		//System.out.println("****** WITHIN AROUND DEMO END********");
	}
	
	/*@Before("targetDemo()")
	public void targetBeforeDemo() {
		System.out.println("****** TARGET BEFORE DEMO ********");
	}
	
	@Before("thisDemo()")
	public void thisBeforeDemo() {
		System.out.println("****** THIS BEFORE DEMO ********");
	}
	
	@Before("annotationDemo()")
	public void annotationBeforeDemo() {
		System.out.println("****** ANNOTATION BEFORE DEMO ********");
	}*/
	
	/*
	 * study JointPoint, getArgs method keeps method's all arguments as object type
	 */
	/*@Before("argsDemo()")
	public void argsBeforeDemo(JoinPoint jp) {
		System.out.println("****** ARGS BEFORE DEMO ********");
		
		for(Object arg: jp.getArgs()) {
			System.out.println("Arg: " + arg);
		}
		
	}*/
	
	@Before("targetDemo() && argsDemo2(exposure, zoom)")
	public void argsBeforeDemo1(int exposure, double zoom) {
		System.out.println("****** ARGS BEFORE DEMO ********   exposure: " + exposure + " and zoom: " +zoom);
		
	}
	
	/*@Before("beanDemo()")
	public void beanBeforeDemo() {
		System.out.println("****** BEAN BEFORE DEMO ********");
	}*/
}
