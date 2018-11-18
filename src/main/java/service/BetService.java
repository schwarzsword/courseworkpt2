package service;

import entity.EndDateEntity;
import entity.LotEntity;

import java.sql.Timestamp;

public interface BetService {
    LotEntity newPrice(LotEntity lot, long bet);
    EndDateEntity checkDate(LotEntity lot, Timestamp now);
}
