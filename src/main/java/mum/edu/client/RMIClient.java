package mum.edu.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

import mum.edu.IGreeting;
import mum.edu.Person;

public class RMIClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springconfigclient.xml");
		IGreeting remoteServer = context.getBean("helloserver", IGreeting.class);
		Person person = new Person("John", "Doe");
		String result = remoteServer.getMessage(person);
		System.out.println("Receiving result: " + result);

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		int sum = remoteServer.calculator('+', 5);
		int mult = remoteServer.calculator('*', 2);

		System.out.println("added 5 : " + sum);
		System.out.println("multiplied by 2 : " + mult);

		stopWatch.stop();

	}

}
