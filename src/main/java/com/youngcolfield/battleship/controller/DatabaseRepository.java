package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface DatabaseRepository extends CrudRepository<Account, Long> {
}
