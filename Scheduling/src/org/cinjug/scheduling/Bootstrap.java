package org.cinjug.scheduling;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

	public static void main(String[] args) throws InterruptedException {

		new ClassPathXmlApplicationContext(new String[] { "scheduling.xml" }).start();

		Thread.sleep(600000);
	}
}
