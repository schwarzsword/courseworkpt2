import config.database.DatabaseConfig;
import entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.*;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        PaintingRepository paintingRepository = (PaintingRepository)ctx.getBean("paintingRepository");
        PaintingEntity paintingEntity = PaintingEntity.newBuilder()
                .setName("testart12342")
                .setAuthor("testautho234r2")
                .setDescription("testDescription223")
                .setImg("testlink2123")
                .build();
        paintingRepository.save(paintingEntity);

//        RegistrationRepository registrationRepository = (RegistrationRepository) ctx.getBean("registrationRepository");
//        RegistrationEntity registrationEntity = RegistrationEntity.newBuilder()
//                .setLogin("testuser1233")
//                .setPassword("qwerty")
//                .build();
//        RegistrationEntity registrationEntity2 = RegistrationEntity.newBuilder()
//                .setLogin("test231user1")
//                .setPassword("qwerty")
//                .build();
//        registrationRepository.save(registrationEntity);
//        registrationRepository.save(registrationEntity2);

//        UsersRepository usersRepository = (UsersRepository)ctx.getBean("usersRepository");
//        UsersEntity usersEntity = UsersEntity.newBuilder()
//                .setRegistration(registrationEntity)
//                .build();
//        usersRepository.save(usersEntity);

//        UsersRepository usersRepository = (UsersRepository)ctx.getBean("usersRepository");
//        UsersEntity usersEntity1 = new UsersEntity();
//        usersEntity1.setName("name1");
//        usersEntity1.setSurname("sname1");
//        usersEntity1.setRegistrationByRegist(registrationRepository.findById(1).get());
//        usersEntity1.setMail("test@gmail.com");
//        usersEntity1.setPhone("1234567890");
//        usersEntity1.setRole(Role.admin);
//        UsersEntity usersEntity2 = new UsersEntity();
//        usersEntity2.setName("name2");
//        usersEntity2.setSurname("sname2");
//        usersEntity2.setRegistrationByRegist(registrationRepository.findById(2).get());
//        usersEntity2.setMail("test2@gmail.com");
//        usersEntity2.setPhone("0098765421");
//        usersEntity2.setRole(Role.admin);
//        usersRepository.save(usersEntity1);
//        usersRepository.save(usersEntity2);
//
//        WalletRepository walletRepository = (WalletRepository)ctx.getBean("walletRepository");
//        WalletEntity walletEntity = new WalletEntity();
//        walletEntity.setUserByOwner(usersRepository.findUsersEntityByMail("test@gmail.com"));
//        walletEntity.setBalance(1000L);
//        WalletEntity walletEntity2 = new WalletEntity();
//        walletEntity2.setUserByOwner(usersRepository.findUsersEntityByMail("test2@gmail.com"));
//        walletEntity2.setBalance(1000L);
//        walletRepository.save(walletEntity);
//        walletRepository.save(walletEntity2);
//
//        LotRepository lotRepository = (LotRepository)ctx.getBean("lotRepository");
//        LotEntity lotEntity = new LotEntity();
//        lotEntity.setPaintingByPainting(paintingRepository.findById(1).get());
//        lotEntity.setStartDate(new Timestamp(System.currentTimeMillis()));
//        lotEntity.setState(State.sold);
//        lotEntity.setStartPrice(100L);
//        lotEntity.setSellerByUsers(usersRepository.findUsersEntityByMail("test@gmail.com"));
//        lotRepository.save(lotEntity);
//
//        EndDateRepository endDateRepository = (EndDateRepository)ctx.getBean("endDateRepository");
//        EndDateEntity endDateEntity = new EndDateEntity();
//        endDateEntity.setLotByLot(lotRepository.findById(1).get());
//        endDateEntity.setExpectingDate(new Timestamp(System.currentTimeMillis()+1000000));
//        endDateEntity.setState(true);
//        endDateRepository.save(endDateEntity);
//
//        PaymentRepository paymentRepository = (PaymentRepository)ctx.getBean("paymentRepository");
//        PaymentEntity paymentEntity = new PaymentEntity();
//        paymentEntity.setWalletBySource(walletRepository.findById(2).get());
//        paymentEntity.setWalletByDestination(walletRepository.findById(1).get());
//        paymentEntity.setSum(200L);
//        paymentRepository.save(paymentEntity);
//
//        DealRepository dealRepository = (DealRepository)ctx.getBean("dealRepository");
//        DealEntity dealEntity = new DealEntity();
//        dealEntity.setEndDateBySoldDate(endDateRepository.findById(1).get());
//        dealEntity.setUsersByCustomer(usersRepository.findUsersEntityByMail("test2@gmail.com"));
//        dealEntity.setPaymentByPayment(paymentRepository.findById(1).get());
//        dealRepository.save(dealEntity);
    }
}
