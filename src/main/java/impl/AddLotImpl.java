package impl;

import entity.EndDateEntity;
import entity.LotEntity;
import entity.PaintingEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.LotRepository;
import repository.PaintingRepository;
import service.AddLotService;

import java.sql.Timestamp;

@Service("AddLotService")
public class AddLotImpl implements AddLotService {
    private final LotRepository lotRepository;
    private final PaintingRepository paintingRepository;

    @Autowired
    public AddLotImpl(LotRepository lotRepository, PaintingRepository paintingRepository){
        this.lotRepository = lotRepository;
        this.paintingRepository = paintingRepository;
    }

    @Transactional
    @Override
    public LotEntity setLot(PaintingEntity painting, Timestamp start_date, Long start_price, UsersEntity seller){
        //paintingRepository.save(painting);
        LotEntity lot = LotEntity.newBuilder()
                .setPainting(painting)
                .setState("on admin")
                .setStartDate(start_date)
                .setSeller(seller)
                .setStartPrice(start_price)
                .build();
        lotRepository.save(lot);
        return lot;
    }


}
