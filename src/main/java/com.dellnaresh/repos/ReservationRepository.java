package com.dellnaresh.repos;

import com.dellnaresh.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by nareshm on 3/1/2016.
 */

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Collection<Reservation>
    findByReservationName(String rn);
}
