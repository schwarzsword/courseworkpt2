package service;

import entity.CertificateEntity;
import entity.LotEntity;
import entity.UsersEntity;

public interface VerificationService {
    LotEntity adminVerification(LotEntity lot); //TODO method for admin only(3 pt), set state on expert or rejected, if seller have unfilled fields or has no money
    LotEntity expertVerification(LotEntity lot, CertificateEntity cert); //TODO method for expert, check certificate or set new
}
