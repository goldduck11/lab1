package TaskManager;

import FormUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@EnableScheduling
public class TaskManager {
    MongoTemplate mongoTemplate;

    @Autowired
    public TaskManager(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Scheduled(fixedRate = 60000)
    public void checkTime() {
        List<User> users = mongoTemplate.findAll(User.class);

        String filePath = "output.txt";
        LocalDateTime currentDate = LocalDateTime.now();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (User user : users) {
                // Проверка, остался ли день или 1 час до expirationDate
                user.getDate().forEach(date -> {
                    String dateString = date;

                    // Преобразование строки в объект Date

                    // Форматтер для строки
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");

                    // Преобразование строки в объект LocalDate
                    LocalDateTime date1 = LocalDateTime.parse(dateString, formatter);
                    long oneDayInMillis = 24 * 60 * 60 * 1000;
                    long oneHourInMillis = 60 * 60 * 1000;
                    if ((date1.isBefore(currentDate.plusHours(1)) || (date1.isBefore(currentDate.plusDays(1))))) {
                        // Запись данных в файл

                        try {
                            writer.write("User: " + user.getName() + ", Expiration Date: " + date + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }

                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
