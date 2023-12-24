package Server;

import Controller.Controller;
import FormUser.User;
import TaskManager.TaskManager;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "Controller")
@ComponentScan(basePackages = "TaskManager")
@RestController
public class JavaServerApplication {


    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    Controller controller = new Controller(this.mongoTemplate);

    @Autowired
    TaskManager taskManager = new TaskManager(this.mongoTemplate);

    @PostMapping("/Login")
    ResponseEntity<?> login(@RequestBody String JSON){
        controller.logIn(JSON);
        return new ResponseEntity<>("Успешный вход", HttpStatus.CREATED);
    }

    @PostMapping("/setTime")
    ResponseEntity<?> add(@RequestBody String JSON) {
        System.out.println("Я здесь");
        boolean save = controller.saveData(JSON);
        if (save == false)
            return new ResponseEntity<>( "Data received not successfully!",HttpStatus.CREATED);
        return new ResponseEntity<>("Data received successfully!", HttpStatus.CREATED);
    }

    @SneakyThrows
    @PostMapping("/getTime")
    ResponseEntity<?> getTime(@RequestBody String JSON){
        User user = controller.getUser();
        if (user==null)
            return new ResponseEntity<>("Такого человека нет", HttpStatus.CREATED);
        return new ResponseEntity<>("Ваши врачи и даты: \n" + user.getSlots() + "\n" + user.getDate(), HttpStatus.CREATED);
    }


}