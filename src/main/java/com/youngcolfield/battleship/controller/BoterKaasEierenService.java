package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.BoterKaasEieren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoterKaasEierenService {
    @Autowired
    private BoterKaasEierenRepository boterKaasEierenRepository;

    public BoterKaasEieren createBoterKaasEieren(){
        BoterKaasEieren bke = new BoterKaasEieren();
        bke.setCells("000000000");
        boterKaasEierenRepository.save(bke);
        return bke;
    }

    public void updateCellsById(Long id, String cells){
        BoterKaasEieren bke = boterKaasEierenRepository.getBoterKaasEierensById(id);
        bke.setCells(cells);
    }
}
