package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.misc.AccountLoginId;
import com.youngcolfield.battleship.misc.AccountVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
            return Response.accepted(accountLoginId).build();
        } catch (Exception e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAccount(@Valid @NotNull  AccountVO accountVO) {

        try{
            AccountLoginId accountLoginId = new AccountLoginId();
            accountLoginId.setId(accountService.login(accountVO));
            return Response.ok(accountLoginId).build();
        } catch (Exception e) {
            return Response.status(HttpStatus.FORBIDDEN.value()).build();
        }
    }



}
