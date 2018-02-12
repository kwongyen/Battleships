package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account register(RegisterVO rvo){

        return accountRepository.register(rvo);
    }
}
