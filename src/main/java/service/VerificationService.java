package service;

import entity.CertificateEntity;
import entity.LotEntity;
import entity.UsersEntity;

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
     * @param admin admin, who verifies the lot
     * @param setOnMarket true if to set lot on selling
     * @return      lot with new status
     */
    LotEntity adminVerification(LotEntity lot, UsersEntity admin,  boolean setOnMarket);
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
     * @param expert expert, who verifies the painting
     * @param setCertificate true if to set certificate and lot state on_admin_verifying
     * @return      lot with new status
     */
    LotEntity expertVerification(LotEntity lot, CertificateEntity cert, UsersEntity expert, boolean setCertificate);
}
