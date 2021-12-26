package oil.moe.dto.loginInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    @Length(min = 1, max = 40)
    @NotEmpty(message = "username can't null !")
    String username;

    @Column
    @Length(min = 1)
    @NotEmpty(message = "password can't null !")
    String password;

    @Column
    @ElementCollection
    @NotEmpty(message = "authority can't null !")
    List<GrantedAuthority> authority;
}
