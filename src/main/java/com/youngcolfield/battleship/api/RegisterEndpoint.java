package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("account")
@Component
public class RegisterEndpoint {

    @Autowired
    public AccountService accountService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(RegisterVO rvo){
        Account account = accountService.register(rvo);
        //Meal result = mealService.save(meal);
        return Response.accepted(account.getId()).build();
        //return Response.ok().build();
    }


}
