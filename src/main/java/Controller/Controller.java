package Controller;

import FormUser.Doctor;
import FormUser.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class Controller {

    private MongoTemplate mongoTemplate;

    private User user;

    @Autowired
    public Controller(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @SneakyThrows
    public boolean saveData(String data) {
        System.out.println("------------------");
        System.out.println("Я в контроллере");
        System.out.println(data);
        Doctor doctor = new ObjectMapper().readValue(data, Doctor.class);
        if (mongoTemplate.exists(Query.query(
                        Criteria.where("UUID").is(String.valueOf(doctor.getUuid()))),
                Doctor.class
        )) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Челикс найден!!!!");
            System.out.println(doctor.toString());
            if (mongoTemplate.exists(Query.query(
                            Criteria.where("UUID").is(String.valueOf(doctor.getUuid()))
                                    .and("data").is(doctor.getSlots().get(0))),
                    Doctor.class
            )) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Данные найдены");
                Query query = new Query(Criteria.where("_id").is(doctor.getUuid()));
                Update update = new Update().pull("Slots", doctor.getSlots().get(0));
                mongoTemplate.updateFirst(query, update, Doctor.class);
                setDataFromUser(doctor);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void setDataFromUser(Doctor doctor) {
        Query query = new Query(Criteria.where("_id").is(user.getUuid()));
        Update update = new Update().push("Slots").each(doctor.getUuid(), doctor.getSlots().get(0));

        mongoTemplate.updateFirst(query, update, User.class);
    }

    public User getUser() {
        System.out.println(this.user.getUuid());
        return mongoTemplate.findOne(Query.query(Criteria.where("uuid").is(String.valueOf(this.user.getUuid()))), User.class);
    }

    @SneakyThrows
    public void logIn(String json) {
        User tempUser = new ObjectMapper().readValue(json,User.class);
        System.out.println("---------------------");
        System.out.println(tempUser.toString());
        System.out.println("---------------------");
        Query query = new Query(Criteria.where("uuid").is(String.valueOf(tempUser.getUuid())));
        System.out.println(query.toString());
        this.user = mongoTemplate.findOne(Query.query(Criteria.where("uuid").is(String.valueOf(tempUser.getUuid())))
                , User.class, "User");
        System.out.println(this.user.toString());
    }
}
