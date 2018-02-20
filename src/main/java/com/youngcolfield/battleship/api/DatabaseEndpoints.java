package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.DatabaseService;
import com.youngcolfield.battleship.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Component
@Path("/database")
public class DatabaseEndpoints {

    @Autowired
    private DatabaseService databaseService;

    @Path("/fill")
    @GET
    public Response fillDatabaseWithAccounts() {
        databaseService.fillDatabaseWithAccounts();
        return Response.ok().build();
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAccounts() {
        Iterable<Account> accounts = databaseService.getAccounts();
        return Response.ok(accounts).build();
    }
}
