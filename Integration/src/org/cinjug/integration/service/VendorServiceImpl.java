package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;
import org.cinjug.integration.domain.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * User: tkaufman
 * Date: Jun 20, 2008
 */
@Component("vendorService")
public class VendorServiceImpl implements VendorService {
    Log log = LogFactory.getLog(getClass());

    public Customer extractCancelledCustomer(Cancellation cancel) {
        log.info("Extracting and validating customer from cancel id# " + cancel.getId());
        return cancel.getCust();
    }

    public String removeCustomer(Customer cust) {
        log.info("Customer " + cust.getNumber() + " removed from vendor system");
        return cust.getId().toString();
    }

}
