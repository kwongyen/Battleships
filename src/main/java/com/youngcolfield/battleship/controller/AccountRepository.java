package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("select a.username from Account a where a.email = id")
    String findUsernameByEmail(@Param("id") long id);

    @Query("select a.statsid from Account a where a.email = :id")
    long findStatsidByEmail(@Param("id") long id);

    @Query("SELECT a from Account a where a.email = :id")
    Account findAccountByEmail(@Param("id") String id);

}
