package kuehnenagel.citytask.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
@Document("cities")
@NoArgsConstructor
@AllArgsConstructor
public class City{
    private String id; // this will come from keycloak. not generated so not id.

    private String name;
    private String photo;
}
