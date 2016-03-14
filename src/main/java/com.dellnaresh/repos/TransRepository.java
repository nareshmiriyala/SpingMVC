package com.dellnaresh.repos;

import com.dellnaresh.entity.Trans;
import com.dellnaresh.entity.TransParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by nareshm on 3/5/2016.
 */
public interface TransRepository extends JpaRepository<Trans, Long> {
    public Collection<Trans> findByType(String type);

    public Collection<Trans> findByDebtorId(Long type);

    public Collection<Trans> findByCreditorId(Long type);
}
