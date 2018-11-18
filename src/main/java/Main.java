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
                .setName("testart2")
                .setAuthor("testauthor2")
                .setDescription("testDescription2")
                .setImg("testlink2")
                .build();
        paintingRepository.save(paintingEntity);

        RegistrationRepository registrationRepository = (RegistrationRepository) ctx.getBean("registrationRepository");
        RegistrationEntity registrationEntity = RegistrationEntity.newBuilder()
                .setLogin("testuser1")
                .setPassword("qwerty")
                .build();
        RegistrationEntity registrationEntity2 = RegistrationEntity.newBuilder()
                .setLogin("testuser4")
                .setPassword("qwerty")
                .build();
        registrationRepository.save(registrationEntity);
        registrationRepository.save(registrationEntity2);


   UsersRepository usersRepository = (UsersRepository)ctx.getBean("usersRepository");
        UsersEntity usersEntity = UsersEntity.newBuilder()
                .setName("name1")
                .setSurname("sname1")
                .setMail("testmail1")
                .setPhone("123")
                .setRole(Role.admin.name())
                .setRegistration(registrationRepository.findRegistrationEntityByLogin("testuser1").get())
                .build();
        UsersEntity usersEntity2 = UsersEntity.newBuilder()
                .setName("name1")
                .setSurname("sname1")
                .setMail("testmail2")
                .setPhone("1234")
                .setRole(Role.admin.name())
                .setRegistration(registrationRepository.findRegistrationEntityByLogin("testuser4").get())
                .build();
        usersRepository.save(usersEntity);
        usersRepository.save(usersEntity2);

        WalletRepository walletRepository = (WalletRepository)ctx.getBean("walletRepository");
        WalletEntity walletEntity1 = WalletEntity.newBuilder()
                .setBalance(1000L)
                .setOwner(usersRepository.findById(1).get())
                .build();
        WalletEntity walletEntity2 = WalletEntity.newBuilder()
                .setBalance(1000L)
                .setOwner(usersRepository.findById(2).get())
                .build();
        walletRepository.save(walletEntity1);
        walletRepository.save(walletEntity2);

        LotRepository lotRepository = (LotRepository)ctx.getBean("lotRepository");
        LotEntity lotEntity = LotEntity.newBuilder()
                .setStartDate(new Timestamp(System.currentTimeMillis()-10000))
                .setStartPrice(100L)
                .setState(State.sold.name())
                .setPainting(paintingRepository.findById(1).get())
                .setSeller(usersRepository.findById(1).get())
                .build();
        lotRepository.save(lotEntity);

        EndDateRepository endDateRepository = (EndDateRepository)ctx.getBean("endDateRepository");
        EndDateEntity endDateEntity = EndDateEntity.newBuilder()
                .setState(true)
                .setExpectingDate(new Timestamp(System.currentTimeMillis()-5000))
                .setLot(lotRepository.findById(1).get())
                .build();
        endDateRepository.save(endDateEntity);

        PaymentRepository paymentRepository = (PaymentRepository)ctx.getBean("paymentRepository");
        PaymentEntity paymentEntity = PaymentEntity.newBuilder()
                .setSum(400L)
                .setSourceWallet(walletRepository.findById(1).get())
                .setDestinationWallet(walletRepository.findById(2).get())
                .build();
        paymentRepository.save(paymentEntity);

        DealRepository dealRepository = (DealRepository)ctx.getBean("dealRepository");
        DealEntity dealEntity = DealEntity.newBuilder()
                .setEndDate(endDateRepository.findById(1).get())
                .setPayment(paymentRepository.findById(1).get())
                .setCustomer(usersRepository.findById(2).get())
                .build();
        dealRepository.save(dealEntity);
    }
}
