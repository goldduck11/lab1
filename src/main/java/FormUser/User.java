package FormUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
@ToString
@EnableMongoRepositories
@Document(collection = "User")
@Component
public class User {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("Date")
    private ArrayList<String> date;
    @JsonProperty("uuidDoctor")
    private ArrayList<String> slots;

}
