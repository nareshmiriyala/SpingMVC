package com.dellnaresh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by nareshm on 3/5/2016.
 */
@Entity
public class Trans {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Long debtorId;
    private Long creditorId;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Trans{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", debtorId=" + debtorId +
                ", creditorId=" + creditorId +
                ", amount=" + amount +
                '}';
    }
}
