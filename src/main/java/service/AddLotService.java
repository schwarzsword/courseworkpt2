package service;

import entity.LotEntity;
import entity.PaintingEntity;
import entity.PaymentEntity;

public interface AddLotService {
    LotEntity setLot(PaintingEntity painting); //TODO set lot's fields, set state on admin;

}
