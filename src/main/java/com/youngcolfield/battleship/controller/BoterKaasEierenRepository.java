package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.BoterKaasEieren;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BoterKaasEierenRepository extends CrudRepository<BoterKaasEieren, Long>{

    @Query("select b from BoterKaasEieren b where b.id = :id")
    BoterKaasEieren getBoterKaasEierensById(@Param("id") Long id);
}
