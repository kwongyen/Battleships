package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
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

        Account registeredAccount = accountRepository.save(account);

        if (registeredAccount == null) {
          return account.getEmail();
        }

      throw new InvalidRegistrationException("This email has already been taken");
    }

    public String login(AccountVO accountVO) throws InvalidLoginException {

      Account account = accountRepository.findOne(accountVO.getEmail());

        if (account == null || !account.getPassword().equals(accountVO.getPassword())) {
            throw new InvalidLoginException("No valid combination of email and password");
        }
        return account.getEmail();
    }
}
