package com.youngcolfield.battleship.UnitTests.api;

import com.youngcolfield.battleship.api.AccountEndpoints;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.AccountVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointsUT {

  @Mock
  private AccountService accountService;

  @InjectMocks
  private AccountEndpoints accountEndpoints;

  @Test
  public void testRegister200(){

    RegisterVO registerVO = new RegisterVO();
    try {
      when(accountService.register(registerVO)).thenReturn("bla@bla.nl");
    } catch (Exception e){
      fail();
    }
    Response response = accountEndpoints.register(registerVO);

    assertEquals(202, response.getStatus());
  }

  @Test
  public void testLogin(){
    AccountVO accountVO = new AccountVO();
    try {
      when(accountService.login(accountVO)).thenReturn("bla@bla.nl");
    } catch (Exception e){
      fail();
    }
    Response response = accountEndpoints.loginAccount(accountVO);

    assertEquals(200, response.getStatus());
  }
}
