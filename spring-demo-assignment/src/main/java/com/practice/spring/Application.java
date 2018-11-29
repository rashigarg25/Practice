package com.practice.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.spring.beans.Logger;
import com.practice.spring.beans.PrintListAndConstructorInitialize;

public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context.xml");

		Logger log = (Logger) appContext.getBean("fileLogger");
		log.log("log printed");

		PrintListAndConstructorInitialize listBean = (PrintListAndConstructorInitialize) appContext.getBean("listBean");
		listBean.printList();

		appContext.close();
	}
}
