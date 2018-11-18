package impl;


import entity.EndDateEntity;
import entity.LotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EndDateRepository;
import repository.LotRepository;
import repository.UsersRepository;
import service.BetService;

import java.sql.Timestamp;

@Service("betService")
public class BetImpl implements BetService {

    private final LotRepository lotRepository;
    private final EndDateRepository endDateRepository;

    @Autowired
    public BetImpl(LotRepository lotRepository, EndDateRepository endDateRepository){
        this.lotRepository = lotRepository;
        this.endDateRepository =endDateRepository;
    }


    @Transactional
    @Override
    public LotEntity newPrice(LotEntity lot, long bet) {
        if(!lot.getEndDateById().getState()){
            lot.setStartPrice(bet);
        }
        lotRepository.save(lot);
        return lot;
    }


    @Transactional
    @Override
    public EndDateEntity checkDate(LotEntity lot, Timestamp now) {
        EndDateEntity endDateEntity = lot.getEndDateById();
        if(endDateEntity.getExpectingDate().getTime()<now.getTime()){
            endDateEntity.setState(true);
        }
        endDateRepository.save(endDateEntity);
        return endDateEntity;
    }
}
