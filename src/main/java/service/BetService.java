package service;

import entity.EndDateEntity;
import entity.LotEntity;

import java.sql.Timestamp;

public interface BetService {
    LotEntity newPrice(long bet); //TODO if state in Date == false;
    EndDateEntity checkDate(Timestamp now); //TODO if now is later, set state == true;
}
