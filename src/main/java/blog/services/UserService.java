package blog.services;

/**
 * Created by fanzhe on 2017/12/27.
 */
public interface UserService {
    boolean authenticate(String username, String password);
}
