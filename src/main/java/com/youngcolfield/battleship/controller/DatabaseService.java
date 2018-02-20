package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseService {

    @Autowired
    private DatabaseRepository databaseRepository;

    public void fillDatabaseWithAccounts(){
        for(int i=1; i<=5; i++){
            Account a = createAccount(i);
            databaseRepository.save(a);
        }
    }

    public Account createAccount(int i){

        Account a = new Account();
        switch (i){
            case 1:
                a.setEmail("mock@email.com");
                a.setUsername("mock");
                a.setPassword("bestpassword");
                a.setCountry("Netherlands");
                break;
            case 2:
                a.setEmail("jasper@email.com");
                a.setUsername("jasper");
                a.setPassword("password");
                a.setCountry("Netherlands");
                break;
            case 3:
                a.setEmail("daniel@email.com");
                a.setUsername("daniel");
                a.setPassword("best");
                a.setCountry("Scotland");
                break;
            case 4:
                a.setEmail("kwong@email.com");
                a.setUsername("kwong");
                a.setPassword("pw1234");
                a.setCountry("Netherlands");
                break;
            case 5:
                a.setEmail("claudio@email.com");
                a.setUsername("claudio");
                a.setPassword("pompkasteel");
                a.setCountry("Netherlands");
                break;
        }




        return a;
    }
    public Iterable<Account> getAccounts(){
        return databaseRepository.findAll();
    }
}
