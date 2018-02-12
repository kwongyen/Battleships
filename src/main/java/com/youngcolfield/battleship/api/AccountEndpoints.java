package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.Account;
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

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAccount(AccountVO accountVO) {

        if (accountService.login(accountVO)) {

            return Response.ok("id").build();
        }

        return Response.status(403).build();
    }

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(RegisterVO rvo) {
        int accountId;
        try {
            accountId = accountService.register(rvo);
        } catch (Exception e) {
            return Response.status(400).build();
        }
        //Meal result = mealService.save(meal);
        return Response.accepted(accountId).build();
        //return Response.ok().build();
    }
}
