package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;
import org.cinjug.integration.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
@MessageEndpoint(input = "customerCancels")
public class CancellationRouter {
    Log log = LogFactory.getLog(getClass());

    @Router
    public List<String> route(Cancellation payload) {
        List<String> outputChannels = new ArrayList<String>();
        if (payload.getProd() == Product.IDSAFE || payload.getProd() == Product.FREECREDITBUREAU) {
            log.info("Routing cancel id# " + payload.getId() + " to Credit Cancels channel.");
            outputChannels.add("creditCancels");
        }
        if (payload.getRefundDue() != null && payload.getRefundDue() > 0) {
            log.info("Routing cancel id# " + payload.getId() + " to Refundable Cancels channel.");
            outputChannels.add("refundableCancels");
        }
        return outputChannels;
    }
}
