package myWebSite.SpringBootDemoProject;

import myWebSite.SpringBootDemoProject.User.UserRepository;
import myWebSite.SpringBootDemoProject.User.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("eeeeeeee@gmail.com");
        user.setPassword("azzzzzz");
        user.setFirstName("zzzzz");
        user.setLastName("zzzz");

        User savedUser = repo.save(user);

        System.out.println("user is saved");
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> OptionalUser = repo.findById(userId);
        User user = OptionalUser.get();
        user.setPassword("hello222");
        repo.save(user);
        User updatedUser = repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello222");
    }

}
