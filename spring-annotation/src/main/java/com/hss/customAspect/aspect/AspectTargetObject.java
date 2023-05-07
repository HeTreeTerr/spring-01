package com.hss.customAspect.aspect;

import org.springframework.stereotype.Component;

@Component
public class AspectTargetObject {

	public void operate(){
		System.out.println("AspectTargetObject operate ==> do some thing");
		/*if(true){
			throw new RuntimeException();
		}*/
	}
}
