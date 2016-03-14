package com.dellnaresh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by nareshm on 3/5/2016.
 */
@Entity
public class TransParty {
    @Id
    @GeneratedValue
    private Long id;

    private Integer type;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TransParty{" +
                "id=" + id +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}
