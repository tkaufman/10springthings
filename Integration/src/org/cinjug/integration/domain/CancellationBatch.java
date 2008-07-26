package org.cinjug.integration.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
public class CancellationBatch {
    List<Cancellation> cancels;
    Date createdDate;

    public void addCancel(Cancellation cancel) {
        if (cancels == null) {
            cancels = new ArrayList<Cancellation>();
        }
        cancels.add(cancel);
    }

    public List<Cancellation> getCancels() {
        return cancels;
    }

    public void setCancels(List<Cancellation> cancels) {
        this.cancels = cancels;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
