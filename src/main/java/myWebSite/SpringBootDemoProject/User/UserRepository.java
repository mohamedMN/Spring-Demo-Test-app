package myWebSite.SpringBootDemoProject.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Integer> {
}