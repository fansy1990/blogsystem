package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fanzhe on 2018/1/3.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
