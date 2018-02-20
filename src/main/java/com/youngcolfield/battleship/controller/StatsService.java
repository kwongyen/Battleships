package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Stats;
import com.youngcolfield.battleship.misc.StatsVO;
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

    public Stats createStats(){
        Stats stat = new Stats();
        stat.setWins(0);
        stat.setLosses(0);
        statsRepository.save(stat);
        return stat;
    }

    public List<Stats> sortByWins(){
        return statsRepository.sortByWins();
    }

    public List<Stats> sortByWinRatio(){
        return statsRepository.sortByWinRatio();
    }

    public Stats getRankUser(StatsVO statsVO){
        Stats statsUser = accountRepository.findStatsidByUsername(statsVO.getUsername());
        return statsRepository.getRankUser(statsUser.getId());
    }


}
