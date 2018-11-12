package services;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import config.database.DatabaseConfig;
import entity.LotEntity;
import entity.PaintingEntity;
import entity.PaymentEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import repository.PaintingRepository;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Objects;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
@Transactional
public class PaintingEntityTest {

    private Logger log = LogManager.getLogger(DatabaseConfig.class);

    private EntityManager entityManager;
    //private ObjectMapper objectMapper;

    @Resource
    private JpaTransactionManager transactionManager;

    @Before
    public void setStart(){
        this.entityManager= Objects.requireNonNull(transactionManager.getEntityManagerFactory()).createEntityManager();

    }

    @After
    public void close(){
        entityManager.close();
    }

    @Autowired
    PaintingRepository paintingRepository;

    public void toJsonAndLog(Object obj){
        Gson gson = new Gson();
        try {
            log.info(gson.toJson(obj));
        }
        catch (JsonIOException e){
            log.info("JsonIOException on toJsonAndLog");
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePainting(){
//        PaintingEntity paintingEntity = PaintingEntity.newBuilder()
//                .setID(1)
//                .setName("qwe")
//                .setAuthor("me")
//                .setDescription("good")
//                .setImg("pic.img")
//                .setLots(new ArrayList<LotEntity>())
//                .build();

        PaintingEntity paintingEntity = PaintingEntity.newBuilder()
                .setName("testart2")
                .setAuthor("testauthor2")
                .setDescription("testDescription2")
                .setImg("testlink2")
                .build();

        entityManager.getTransaction().begin();

        try{
            PaintingEntity paintDB = paintingRepository.findById(1).get();
            log.info("_________________TEST VALUES_________________");
            toJsonAndLog(paintDB);
            log.info("_____________________________________________");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.getTransaction().rollback();
        }


    }


}
