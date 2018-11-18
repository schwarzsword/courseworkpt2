package service;

import entity.CertificateEntity;
import entity.LotEntity;

public interface VerificationService {
    /**
     * Returns LotEntity with valid information
     * about it's state in auction.
     * <p>
     * Method allows administrator to prove that seller is
     * can be trusted, and his profile is filled or
     * reject lot
     *
     *
     * @param  lot  lot that meant to change status
     * @return      lot with new status
     */
    LotEntity adminVerification(LotEntity lot); //TODO method for admin only(3 pt), set state on expert or rejected, if seller have unfilled fields or has no money
    /**
     * Returns LotEntity with valid information
     * about it's state in auction.
     * <p>
     * Method allows expert to check certificate of painting
     * or register new painting
     *
     *
     * @param  lot  lot that meant to change status
     * @param cert certificate of painting's identity
     * @return      lot with new status
     */
    LotEntity expertVerification(LotEntity lot, CertificateEntity cert); //TODO method for expert, check certificate or set new
}
