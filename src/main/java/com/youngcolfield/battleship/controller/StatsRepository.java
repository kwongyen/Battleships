package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatsRepository extends CrudRepository<Stats, Long> {

    @Query("select s from Stats s order by s.wins desc")
    List<Stats> getRanking();
}
