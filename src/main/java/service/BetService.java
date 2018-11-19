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
     * @param  lot  lot where bet is being made
     * @param  bet  value of last bet
     * @return      lot with actual price
     */
    LotEntity newPrice(LotEntity lot, long bet);
    /**
     * Returns LotEntity with valid information
     * about expiring betting date.
     * <p>
     * Method allows to check date.
     * If state == true then Lot was sold and date ready to be
     * written into a deal
     *
     * @param  lot  lot which is checked on end
     * @param  now  server's current time
     * @return      lot with actual state of date
     */
    EndDateEntity checkDate(LotEntity lot, Timestamp now);
}
