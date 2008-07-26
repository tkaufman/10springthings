package org.cinjug.integration.domain;

import java.util.Date;

/**
 * User: tkaufman
 * Date: Jun 19, 2008
 */
public class Cancellation {
    int id;
    Customer cust;
    CancelReason reason;
    Date cancelDate;
    Product prod;
    Double refundDue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public CancelReason getReason() {
        return reason;
    }

    public void setReason(CancelReason reason) {
        this.reason = reason;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public Double getRefundDue() {
        return refundDue;
    }

    public void setRefundDue(Double refundDue) {
        this.refundDue = refundDue;
    }
}
