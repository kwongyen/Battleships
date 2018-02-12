package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account, String> {
}
