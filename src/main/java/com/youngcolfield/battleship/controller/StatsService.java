package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Stats> getRanking(){
        return statsRepository.getRanking();

    }

}
