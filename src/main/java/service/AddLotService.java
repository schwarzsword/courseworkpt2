package service;

import entity.LotEntity;
import entity.PaintingEntity;
import entity.PaymentEntity;
import entity.UsersEntity;

import java.sql.Timestamp;

public interface AddLotService {
    /**
     * Returns LotEntity instance with filled fields that deployed into database
     * <p>
     * Method allows set up new lot to work with.
     * Default value of state is on_admin_verifying.
     * Includes instance of PaintingEntity
     *
     * @param  painting  painting as object of auction
     * @param seller User, who sells this painting
     * @param start_date the starting date of selling
     * @param start_price the starting price of lot
     * @return      Ready to use lotEntity object
     */
    LotEntity setLot(PaintingEntity painting, Timestamp start_date, Long start_price, UsersEntity seller);

}
