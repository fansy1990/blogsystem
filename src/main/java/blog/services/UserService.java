package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by fanzhe on 2017/12/27.
 */
public interface UserService {
    boolean authenticate(String username, String password);
    List<User> findAll();
    User  findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
