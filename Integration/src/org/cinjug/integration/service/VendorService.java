package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;
import org.cinjug.integration.domain.Customer;

/**
 * User: tkaufman
 * Date: Jun 20, 2008
 */
public interface VendorService {

    public Customer extractCancelledCustomer(Cancellation cancel);

    public String removeCustomer(Customer cust);

}
