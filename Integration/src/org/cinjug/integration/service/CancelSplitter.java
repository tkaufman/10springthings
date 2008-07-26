package org.cinjug.integration.service;

import org.cinjug.integration.domain.Cancellation;
import org.cinjug.integration.domain.CancellationBatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import java.util.List;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
@MessageEndpoint(input = "batchCancels", output = "customerCancels")
public class CancelSplitter {
    Log log = LogFactory.getLog(getClass());

    @Splitter
    public List<Cancellation> split(CancellationBatch batch) {
        log.info("Splitting batch into " + batch.getCancels().size() + " individual cancels");
        return batch.getCancels();
    }
}
