package com.youngcolfield.battleship.UnitTests.controller;

import com.youngcolfield.battleship.controller.AccountRepository;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.AccountVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.junit.After;
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

  @Mock
  private AccountRepository accountRepository;

  @InjectMocks
  private AccountService accountService;

  @Test
  public void testRegister200(){

    String testEmail = "bla@bla.nl";
    String testPassword = "123123";

    RegisterVO registerVO = new RegisterVO();
    registerVO.setEmail(testEmail);
    registerVO.setPassword(testPassword);
    registerVO.setUsername("bloebla");

    when(accountRepository.save(any(Account.class))).thenReturn(null);

    String answer;

    try {
      answer = accountService.register(registerVO);
    } catch (Exception e) {

      System.out.println(e);

      fail();
      return;
    }

    assertEquals(testEmail, answer);
  }

  public void testRegister500(){

    String testEmail = "bla@bla.nl";
    String testPassword = "123123";

    RegisterVO registerVO = new RegisterVO();
    registerVO.setEmail(testEmail);
    registerVO.setPassword(testPassword);
    registerVO.setUsername("bloebla");

    Account account = new Account();
    account.setEmail(testEmail);

    when(accountRepository.save(any(Account.class))).thenReturn(account);

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
  public void testLogin(){
    String testEmail = "bla@bla.nl";
    String testPassword = "123123";

    AccountVO accountVO = new AccountVO();
    accountVO.setEmail(testEmail);
    accountVO.setPassword(testPassword);

    Account account = new Account();
    account.setPassword(testPassword);
    account.setEmail(testEmail);

    when(accountRepository.findOne(any(String.class))).thenReturn(account);

    String email;

    try {
      email = accountService.login(accountVO);
    } catch (Exception e) {
      fail();
      return;
    }
    assertEquals(email, testEmail);
  }
}
