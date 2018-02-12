package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.misc.AccountLoginId;
import com.youngcolfield.battleship.misc.AccountVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountEndpoints {

    @Autowired
    private AccountService accountService;

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RegisterVO registerVO) {
        try {
            AccountLoginId accountLoginId = new AccountLoginId();
            accountLoginId.setId(accountService.register(registerVO));
            return Response.accepted(accountLoginId).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAccount(AccountVO accountVO) {

        try{
            AccountLoginId accountLoginId = new AccountLoginId();
            accountLoginId.setId(accountService.login(accountVO));
            return Response.ok(accountLoginId).build();
        } catch (Exception e) {
            return Response.status(403).build();
        }
    }
}
