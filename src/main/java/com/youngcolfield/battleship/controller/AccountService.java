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

    public int register(RegisterVO registerVO){

        Account account = new Account();

        account.setFirstName(registerVO.getFirstName());
        account.setLastName(registerVO.getLastName());

        if (accountRepository.findOne(registerVO.getEmailAddress()) == null){
            Account registeredAccount = accountRepository.save(account);
            return registeredAccount.getId();
        }

        throw new RuntimeException();
    }

    public Boolean login(AccountVO accountVO) {

    return true;
    }

}
