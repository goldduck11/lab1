package DB;

import FormUser.Doctor;
import FormUser.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends MongoRepository<User,String> {
    @Query("{uuid:'?0'}")
    Doctor findUserByUuid(UUID uuid);

    @Query
    List<User> findAll();
}
