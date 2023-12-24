/*
package DB;

import FormUser.Doctor;
import FormUser.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoTransaction {

    public User getUserFromUUID(UUID uuid) {
        Document query = new Document("uuid", uuid.toString());
        return DBHelper.getUserCollection().find(query, User.class).first();
    }

    public Doctor getDoctorFromUUID(UUID uuid) {
        Document query = new Document("uuid", uuid.toString());
        return DBHelper.getDoctorCollection().find(query, Doctor.class).first();
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> doctorList = new ArrayList<>();
        for (Doctor doctor : DBHelper.getDoctorCollection().find()) {
            doctorList.add(doctor);
        }
        return doctorList;
    }

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        for (User user : DBHelper.getUserCollection().find()) {
            userList.add(user);
        }
        return userList;
    }

    public void update(Doctor doctor) {
        UUID uuid = doctor.getUuid();
        Document query = new Document("uuid", uuid.toString());
        Doctor existingDoctor = DBHelper.getDoctorCollection().find(query, Doctor.class).first();

        if (existingDoctor != null) {
            DBHelper.getDoctorCollection().replaceOne(query, doctor);
        }
    }


    public void update(User user) {
        UUID uuid = user.getUuid();
        Document query = new Document("uuid", uuid.toString());
        User existingUser = DBHelper.getUserCollection().find(query, User.class).first();

        if (existingUser != null) {
            DBHelper.getUserCollection().replaceOne(query, user);
        }
    }

    public void deleteUser(User user) {
        UUID uuid = user.getUuid();
        DBHelper.getUserCollection().deleteOne(new Document("uuid", uuid.toString()));
    }

    public void deleteDoctor(Doctor doctor) {
        UUID uuid = doctor.getUuid();
        DBHelper.getDoctorCollection().deleteOne(new Document("uuid", uuid.toString()));
    }


    public void addUser(User user) {
        DBHelper.getUserCollection().insertOne(user);
    }

    public void addDoctor(Doctor doctor) {
        DBHelper.getDoctorCollection().insertOne(doctor);
    }
}
*/
