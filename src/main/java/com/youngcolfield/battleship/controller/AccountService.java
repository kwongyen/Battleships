package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Stats;
import com.youngcolfield.battleship.exceptions.InvalidLoginException;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.youngcolfield.battleship.misc.AccountVO;

import java.util.Optional;

@Service
@Transactional
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public String register(RegisterVO registerVO) throws InvalidRegistrationException {

    Account account = new Account();

    account.setEmail(registerVO.getEmail());
    account.setPassword(registerVO.getPassword());
    account.setUsername(registerVO.getUsername());
    account.setType(1);

    String username = accountRepository.findUsernameByEmail(registerVO.getEmail());

    if (username != null) {
      throw new InvalidRegistrationException("This email has already been taken");
    }

    accountRepository.save(account);

    return account.getEmail();
  }

  public String login(AccountVO accountVO) throws InvalidLoginException {

    Account account = accountRepository.findAccountByEmail(accountVO.getEmail());

    if (account == null || !accountVO.getPassword().equals(account.getPassword())) {
      throw new InvalidLoginException("No valid combination of email and password");
    }
    return account.getEmail();
  }
}
