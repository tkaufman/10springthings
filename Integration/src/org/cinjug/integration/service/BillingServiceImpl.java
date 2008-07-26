package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
@Component("billingService")
public class BillingServiceImpl implements BillingService {
    Log log = LogFactory.getLog(getClass());

    public void sendRefund(Cancellation cancel) {
        log.info("Credited refund for $" + cancel.getRefundDue() + " to " + cancel.getCust().getName() + " for cancel id# " + cancel.getId());
    }
}
