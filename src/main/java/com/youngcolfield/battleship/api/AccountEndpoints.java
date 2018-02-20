package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.misc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import sun.nio.ch.SelectorImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Path("/account")
public class AccountEndpoints {

    @Autowired
    private AccountService accountService;

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid @NotNull RegisterVO registerVO) {
        try {
            AccountLoginId accountLoginId = new AccountLoginId();
            accountLoginId.setId(accountService.register(registerVO));
            return Response.ok().build();

        } catch (Exception e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(new StatusVO(e.toString())).build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAccount(@Valid @NotNull AccountVO accountVO) {
        try{
            AccountLoginId accountLoginId = new AccountLoginId();
            accountLoginId.setId(accountService.login(accountVO));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(HttpStatus.FORBIDDEN.value()).entity(new StatusVO(e.toString())).build();
        }
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts() {
        List<SimpleAccount> accounts = accountService.getAccounts();
        return Response.ok(accounts).build();
    }

}
