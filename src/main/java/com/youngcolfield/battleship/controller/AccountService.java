package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.misc.AccountVO;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public Boolean login(AccountVO accountVO) {

    return true;
  }

}
