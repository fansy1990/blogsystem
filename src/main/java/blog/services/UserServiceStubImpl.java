package blog.services;

import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by fanzhe on 2017/12/27.
 */
@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        // Provide a sample password check:username == password
        return Objects.equals(username, password);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
