package DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
public class DBHelper {
//    private static final String MONGO_URI = "mongodb://localhost:27017";
//    private static MongoClient client;
//    private static MongoDatabase database;
//    private static MongoCollection<User> userCollection;
//    private static MongoCollection<Doctor> doctorCollection;
//    private static CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
//            MongoClientSettings.getDefaultCodecRegistry(),
//            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
//    );
//
//
//    private final String exampleDoctor =
//            "{" +
//                    "\"uuid\" : " + "\"" + UUID.randomUUID() + "\"," +
//                    "\"name\" : \"gwergrw\"," +
//                    "\"spec\" : \"Треапевт\"," +
//                    "\"slots\": [\"2023-12-17T09:00:00.000Z\", \"2023-12-17T09:30:00.000Z\"]" +
//                    "}";
//
//    private final static String exampleUser =
//            "{" +
//                    "\"uuid\" : " + "\"" + UUID.randomUUID() + "\"," +
//                    "\"name\":\"gwrgrw\"," +
//                    "\"phone\": \"531531\"" +
//                    "}";
//
//
////    public DBHelper() {
////        this.client = new MongoClient();
////        this.database = client.getDatabase("NewsService").withCodecRegistry(codecRegistry);
////        this.userCollection = database.getCollection("News", User.class);
////        this.doctorCollection = database.getCollection("Category", Doctor.class);
////    }
//
//    *
//     * @return возвращает коннект
//
//    private static MongoClient getConnection(){
//        if (client == null){
//            client = new MongoClientImpl(new Mon);
//        }
//        return client;
//    }
//
//    //TODO: Непонятно почему не работает конвертатор стрингга в json объект и в document
//    *
//     * Хрень для создания двух изначльных пользователей(при запуске)
//
//    public void addExampleUsers(){
//        try {
//            if (getDoctorCollection().countDocuments() == 0 || getUserCollection().countDocuments() == 0) {
//                Doctor doctor = new ObjectMapper().readValue(exampleDoctor, Doctor.class);
//                User user = new ObjectMapper().readValue(exampleUser, User.class);
//                getDoctorCollection().insertOne(doctor);
//                getUserCollection().insertOne(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    *
//     * @return получает массив из всех докторов
//
//    public static MongoCollection<Doctor> getDoctorCollection() {
//        client = getConnection();
//        database = client.getDatabase("Hospital").withCodecRegistry(codecRegistry);
//        return doctorCollection = database.getCollection("Doctor", Doctor.class);
//    }
//
//    *
//     * @return Получает массив из всех полдьзователей системы
//
//    public static MongoCollection<User> getUserCollection() {
//        client = getConnection();
//        database = client.getDatabase("Hospital").withCodecRegistry(codecRegistry);
//        return userCollection = database.getCollection("User", User.class);
//    }


    @Autowired
    public DBHelper(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private MongoTemplate mongoTemplate;

}
