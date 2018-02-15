package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account, String> {
    @Query("SELECT a.username from Account a where a.email = :id")
    String findUsernameByEmail(@Param("id") long id);

}
