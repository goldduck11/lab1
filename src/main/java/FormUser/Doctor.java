package FormUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
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
@Document(collection = "Doctor")
@Component
public class Doctor {
    @JsonProperty("uuid")
    @Id
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("spec")
    private String spec;
    @JsonProperty("slots")
    private ArrayList<String> slots;



}
