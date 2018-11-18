package service;

import entity.LotEntity;
import entity.PaintingEntity;
import entity.PaymentEntity;

public interface AddLotService {
    /**
     * Returns LotEntity instance with filled fields that deployed into database
     * <p>
     * Method allows set up new lot to work with.
     * Default value of state is on_admin_verifying.
     * Includes instance of PaintingEntity
     *
     * @param  painting  painting as object of auction
     * @return      Ready to use lotEntity object
     */
    LotEntity setLot(PaintingEntity painting); //TODO set lot's fields, set state on admin;

}
