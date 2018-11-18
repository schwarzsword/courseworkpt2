package service;

import entity.EndDateEntity;
import entity.LotEntity;

import java.sql.Timestamp;

public interface BetService {
    /**
     * Returns LotEntity with last valid bet
     * <p>
     * Method allows to set last price to the lot
     *
     * @param  bet  value of last bet
     * @return      lot with actual price
     */
    LotEntity newPrice(long bet); //TODO if state in Date == false;
    /**
     * Returns LotEntity with valid information
     * about expiring betting date.
     * <p>
     * Method allows to check date.
     * If state == true -> Lot was sold and date ready to be
     * written into a deal
     *
     * @param  now  server's current time
     * @return      lot with actual state of date
     */
    EndDateEntity checkDate(Timestamp now); //TODO if now is later, set state == true;
}
