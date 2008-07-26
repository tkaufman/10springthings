package org.cinjug.integration.service;

import org.cinjug.integration.domain.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.channel.MessageChannel;
import org.springframework.integration.message.GenericMessage;

import java.util.Date;
import java.util.Random;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */

public class RandomCancellationGeneratorImpl implements CancellationGenerator {
    Log log = LogFactory.getLog(getClass());

    private Random rand = new Random();
    private Customer cust = new Customer();

    // Injected
    private MessageChannel batchChannel;

    public void setBatchChannel(MessageChannel batchChannel) {
        this.batchChannel = batchChannel;
    }

    public RandomCancellationGeneratorImpl() {
        cust.setName("Todd");
        cust.setNumber(123456789);
        cust.setId(123456789L);
    }

    public void publishCancellations() {
        CancellationBatch batch = new CancellationBatch();

        log.info("Generating cancellations");
        for (int i = 0; i < 10; i++) {
            batch.addCancel(generateRandomCancellation(i));
        }

        log.info("Constructing message and storing on the batch channel");
        GenericMessage<CancellationBatch> msg = new GenericMessage<CancellationBatch>(batch);
        batchChannel.send(msg);
    }

    private Cancellation generateRandomCancellation(int id) {
        Cancellation can = new Cancellation();
        can.setId(id);
        can.setCust(cust);
        int prodIndex = rand.nextInt(Product.values().length);
        can.setProd(Product.values()[prodIndex]);
        int reasonIndex = rand.nextInt(CancelReason.values().length);
        can.setReason(CancelReason.values()[reasonIndex]);
        can.setCancelDate(new Date());
        if (can.getReason() == CancelReason.EXPENSIVE) {
            can.setRefundDue(rand.nextDouble());
        }
        return can;
    }

}
