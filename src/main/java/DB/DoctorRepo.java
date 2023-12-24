package DB;

import FormUser.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoctorRepo extends MongoRepository<Doctor,String> {

    @Query("{uuid:'?0'}")
    Doctor findDoctorById(UUID uuid);

    @Query
    List<Doctor> findAll();
}
