package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseService {

    @Autowired
    private StatsRepository statsRepository;

    @Autowired
    private DatabaseRepository databaseRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatsService statsService;

    public void fillDatabaseWithAccounts(){
        for(int i=1; i<=5; i++){
            Account a = createAccount(i);
            if(accountRepository.findAccountByEmail(a.getEmail()) == null){
                databaseRepository.save(a);
            }
        }
    }

    public Account createAccount(int i){
        Stats stats = new Stats();
        Account a = new Account();
        switch (i){
            case 1:
                a.setEmail("mock@email.com");
                a.setUsername("mock");
                a.setPassword("bestpassword");
                a.setCountry("Netherlands");

                stats.setLosses(0);
                stats.setWins(3);
                a.setStatsid(statsRepository.save(stats));
                break;
            case 2:
                a.setEmail("jasper@email.com");
                a.setUsername("jasper");
                a.setPassword("password");
                a.setCountry("Netherlands");

                stats.setLosses(4);
                stats.setWins(10);
                a.setStatsid(statsRepository.save(stats));
                break;
            case 3:
                a.setEmail("daniel@email.com");
                a.setUsername("daniel");
                a.setPassword("best");
                a.setCountry("Scotland");

                stats.setLosses(10);
                stats.setWins(22);
                a.setStatsid(statsRepository.save(stats));
                break;
            case 4:
                a.setEmail("kwong@email.com");
                a.setUsername("kwong");
                a.setPassword("pw1234");
                a.setCountry("Netherlands");

                stats.setLosses(1);
                stats.setWins(7);
                a.setStatsid(statsRepository.save(stats));
                break;
            case 5:
                a.setEmail("claudio@email.com");
                a.setUsername("claudio");
                a.setPassword("pompkasteel");
                a.setCountry("Netherlands");
                stats.setLosses(9);
                stats.setWins(9);
                a.setStatsid(statsRepository.save(stats));
                break;
        }




        return a;
    }
    public Iterable<Account> getAccounts(){
        return databaseRepository.findAll();
    }
}
