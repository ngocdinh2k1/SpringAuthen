package SpringJwtAuthentication.SpringAuthen.User;

import SpringJwtAuthentication.SpringAuthen.user.User;
import SpringJwtAuthentication.SpringAuthen.user.UserRepository;
import jdk.dynalink.linker.support.Guards;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    UserRepository repo;

    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "dinh1105";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User newUser = new User("dinh@gmail.com", encodedPassword);

        User savedUser = repo.save(newUser);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }


}
