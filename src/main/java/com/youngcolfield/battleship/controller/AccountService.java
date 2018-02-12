package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
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

    public long register(RegisterVO registerVO){

        Account account = new Account();

        account.setEmail(registerVO.getEmail());
        account.setPassword(registerVO.getPassword());
        account.setUsername(registerVO.getUsername());

        if (accountRepository.findOne(registerVO.getEmail()) == null){
            Account registeredAccount = accountRepository.save(account);
            return registeredAccount.getId();
        }

        throw new RuntimeException();
    }

    public long login(AccountVO accountVO) {

        Account account = accountRepository.findOne(accountVO.getEmail());

        if (account == null || !account.getPassword().equals(accountVO.getPassword())) {
            throw new RuntimeException();
        }

    return account.getId();
    }

}
