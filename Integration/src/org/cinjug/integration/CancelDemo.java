package org.cinjug.integration;

import org.cinjug.integration.service.CancellationGenerator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: tkaufman
 * Date: Jun 20, 2008
 */
public class CancelDemo {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
        CancellationGenerator gen = (CancellationGenerator) context.getBean("generator");
        gen.publishCancellations();
    }
}
