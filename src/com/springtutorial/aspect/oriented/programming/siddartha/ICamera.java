package com.springtutorial.aspect.oriented.programming.siddartha;

public interface ICamera {

	void snap() throws Exception;

	void snap(int exposure);

	void snapNightMode();

}