package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
public interface BillingService {

    public void sendRefund(Cancellation cancel);
}
