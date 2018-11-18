package service;

import entity.LotEntity;
import entity.PaintingEntity;
import entity.PaymentEntity;
import entity.UsersEntity;

import java.sql.Timestamp;

public interface AddLotService {
    public LotEntity setLot(PaintingEntity painting, Timestamp start_date, Long start_price, UsersEntity seller);

}
