package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Stats;
import com.youngcolfield.battleship.exceptions.InvalidLoginException;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.AccountLoginId;
import com.youngcolfield.battleship.misc.RegisterVO;
import com.youngcolfield.battleship.misc.SimpleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.youngcolfield.battleship.misc.AccountVO;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private StatsRepository statsRepository;

  public Account getAccount(String accountId){
    return accountRepository.findAccountByEmail(accountId);
  }

  public String register(RegisterVO registerVO) throws InvalidRegistrationException {

    Account account = new Account();

    account.setEmail(registerVO.getEmail());
    account.setPassword(registerVO.getPassword());
    account.setUsername(registerVO.getUsername());
    account.setType(1);

    String username = accountRepository.findUsernameByEmail(registerVO.getEmail());
    String email = accountRepository.findEmailByUsername(registerVO.getUsername());

    if (username != null) {
      throw new InvalidRegistrationException("This email has already been taken");
    }
    if (email != null) {
      throw new InvalidRegistrationException("This username has already been taken");
    }

    accountRepository.save(account);

    return account.getEmail();
  }

  public String login(AccountVO accountVO) throws InvalidLoginException {

    Account account = accountRepository.findAccountByEmail(accountVO.getEmail());

    if (account == null || !accountVO.getPassword().equals(account.getPassword())) {
      throw new InvalidLoginException("No valid combination of email and password");
    }
    return account.getEmail();
  }

  public ArrayList<SimpleAccount> getAccounts(){
    List<Account> accounts = accountRepository.findAllAccounts();
    ArrayList<SimpleAccount> simpleAccountList = new ArrayList<>();
    for(Account a : accounts){
      SimpleAccount simpleAccount = new SimpleAccount();
      simpleAccount.setUsername(a.getUsername());
      simpleAccount.setCountry(a.getCountry());

      Stats stat = statsRepository.getRankUser(a.getId());
      int win = stat.getWins();
      int loss = stat.getLosses();
      simpleAccount.setWins(win);
      simpleAccount.setLosses(loss);
      if((win+loss) != 0) {
        double ratio = (double) win/( (double) win+(double) loss);
        ratio = Math.round(ratio * 100.0) / 100.0;
        simpleAccount.setWinratio(ratio);
      }else{
        simpleAccount.setWinratio(0);
      }
      simpleAccountList.add(simpleAccount);
    }
    return simpleAccountList;
  }
  public void deleteAccount(AccountLoginId account) throws InvalidLoginException{
    Account a = accountRepository.findAccountByEmail(account.getId());
    if(a == null){
      throw new InvalidLoginException("This account does not exist");
    }
    accountRepository.delete(a);
  }

}
