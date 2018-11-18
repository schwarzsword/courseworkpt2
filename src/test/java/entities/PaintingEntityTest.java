package entities;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import config.database.DatabaseConfig;
import entity.PaintingEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
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
import java.util.Objects;
import java.lang.*;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
@Transactional
public class PaintingEntityTest {

    private Logger log = LogManager.getLogger(DatabaseConfig.class);

    private EntityManager entityManager;

    @Resource
    private JpaTransactionManager transactionManager;

    @Before
    public void setStart(){
        this.entityManager= Objects.requireNonNull(transactionManager.getEntityManagerFactory()).createEntityManager();
        String name = "testart2";
        String author = "testauthor2";
        String descr = "testDescription2";
        String img = "testlink2";
        PaintingEntity paintingEntity = PaintingEntity.newBuilder()
                .setName(name)
                .setAuthor(author)
                .setDescription(descr)
                .setImg(img)
                .build();
        paintingRepository.save(paintingEntity);



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
            String show = gson.toJson(obj);
            log.info(show);
        }
        catch (JsonIOException e){
            log.info("JsonIOException on toJsonAndLog");
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePainting(){


        entityManager.getTransaction().begin();

        try{
            PaintingEntity paintDB = paintingRepository.findById(1).get();
            log.info("_________________TEST VALUES_________________");
            toJsonAndLog(paintDB);
            log.info("_____________________________________________");

            //List<PaintingEntity> result =  paintingRepository.findAllByAuthor(author);
            //result.forEach(e->toJsonAndLog(e));

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
