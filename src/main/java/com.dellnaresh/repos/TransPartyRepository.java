package com.dellnaresh.repos;

import com.dellnaresh.entity.Reservation;
import com.dellnaresh.entity.TransParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by nareshm on 3/5/2016.
 */
public interface TransPartyRepository extends JpaRepository<TransParty, Long> {
    public Collection<TransParty> findByType(Integer type);
}
