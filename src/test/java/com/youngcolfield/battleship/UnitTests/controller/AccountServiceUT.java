package com.youngcolfield.battleship.UnitTests.controller;

import com.youngcolfield.battleship.controller.AccountRepository;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.exceptions.InvalidLoginException;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.AccountVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceUT {

  final static String TESTEMAIL = "daniel@email.com";
  final static String TESTPASSWORD = "123123";
  
  @Mock
  private AccountRepository accountRepository;

  @InjectMocks
  private AccountService accountService;

  @Test
  public void testRegister200(){

    RegisterVO registerVO = new RegisterVO();
    registerVO.setEmail(TESTEMAIL);
    registerVO.setPassword(TESTPASSWORD);
    registerVO.setUsername("kloekie");

    /// MOCKITO
    when(accountRepository.findUsernameByEmail(any(String.class))).thenReturn(null);

    String answer;

    try {
      answer = accountService.register(registerVO);
    } catch (Exception e) {
      fail();
      return;
    }

    /// MOCKITO
    assertEquals(TESTEMAIL, answer);
  }

  @Test
  public void testRegister500(){

    RegisterVO registerVO = new RegisterVO();
    registerVO.setEmail(TESTEMAIL);
    registerVO.setPassword(TESTPASSWORD);
    registerVO.setUsername("bloebla");

    Account account = new Account();
    account.setEmail(TESTEMAIL);

    when(accountRepository.findUsernameByEmail(any(String.class))).thenReturn(TESTEMAIL);

    try {
      accountService.register(registerVO);
    } catch (InvalidRegistrationException e){
      return;
    } catch (Exception e) {
      fail();
    }
    fail();
  }

  @Test
  public void testLogin200(){
    AccountVO accountVO = new AccountVO();
    accountVO.setEmail(TESTEMAIL);
    accountVO.setPassword(TESTPASSWORD);

    Account account = new Account();
    account.setEmail(TESTEMAIL);
    account.setPassword(TESTPASSWORD);

    when(accountRepository.findAccountByEmail(any(String.class))).thenReturn(account);

    String email;
    try {
      email = accountService.login(accountVO);
    } catch (Exception e) {
      fail();
      return;
    }
    assertEquals(email, TESTEMAIL);
  }


  @Test
  public void testLogin400(){
    AccountVO accountVO = new AccountVO();
    accountVO.setEmail(TESTEMAIL);
    accountVO.setPassword(TESTPASSWORD);

    Account account = new Account();
    account.setEmail(TESTEMAIL);
    account.setPassword(TESTPASSWORD);

    when(accountRepository.findAccountByEmail(any(String.class))).thenThrow(InvalidLoginException.class);

    try {
      accountService.login(accountVO);
      fail();
    } catch (Exception e) {
      return;
    }
  }
}
