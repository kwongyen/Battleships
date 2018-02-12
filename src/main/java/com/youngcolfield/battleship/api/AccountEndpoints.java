package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.misc.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/path")
public class AccountEndpoints {

  @Autowired
  private AccountService accountService;

  @Path("/login")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response loginAccount(AccountVO accountVO) {

    if (accountService.login(accountVO)){

      return Response.ok("id").build();
    }

    return Response.status(403).build();
  }

}
