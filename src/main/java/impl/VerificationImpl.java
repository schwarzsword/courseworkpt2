package impl;


import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CertificateRepository;
import repository.LotRepository;
import repository.PaintingRepository;
import service.VerificationService;

import java.sql.Timestamp;


@Service("verificationService")
public class VerificationImpl implements VerificationService {

    private final LotRepository lotRepository;
    private final PaintingRepository paintingRepository;
    private final CertificateRepository certificateRepository;

    @Autowired
    public VerificationImpl(LotRepository lotRepository, PaintingRepository paintingRepository, CertificateRepository certificateRepository){
        this.lotRepository = lotRepository;
        this.paintingRepository = paintingRepository;
        this.certificateRepository =certificateRepository;
    }

    @Transactional
    @Override
    public LotEntity adminVerification(LotEntity lot, UsersEntity admin, boolean setOnMarket) {
        if(admin.getRole().equals(Role.admin.toString())){
            UsersEntity seller = lot.getSellerByUsers();
            if (
                (seller.getWalletById().getBalance() == 0)
                ||(seller.getMail()==null)
                ||(seller.getWalletById() == null)
                ||(seller.getName()==null)
                ||(seller.getSurname()==null)
                ||(seller.getRegistrationByRegist()==null)
                ||(!seller.getRole().equals(Role.user.toString()))
                ||(seller.getRole()==null)
            ){
                lot.setState(State.rejected.toString());
            }
            else {
                lot.setState(State.on_market.toString());
            }
            lotRepository.save(lot);
            return lot;
        }
        else return null;
    }

    @Override
    public LotEntity expertVerification(LotEntity lot, CertificateEntity cert, UsersEntity expert, boolean setCertificate) {
        if(expert.getRole().equals(Role.expert.toString())) {
            PaintingEntity paint = lot.getPaintingByPainting();
            if(setCertificate) {
                if (cert != null) {
                    paint.setCertificateByCertificate(cert);
                } else {
                    CertificateEntity certificateEntity = CertificateEntity.newBuilder()
                            .setDate(new Timestamp(System.currentTimeMillis()))
                            .setExpert(expert)
                            .setPainting(paint)
                            .build();
                    certificateRepository.save(certificateEntity);
                    paint.setCertificateByCertificate(certificateEntity);
                }
                lot.setState(State.on_admin_verifying.toString());
            }
            else lot.setState(State.rejected.toString());
            paintingRepository.save(paint);
            return lot;
        }
        else return null;
    }
}
